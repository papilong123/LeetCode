import collections
from typing import List


class LockingTree:

    def __init__(self, parent: List[int]):
        self.LOCKED = 0
        self.FREE = 1
        self.n = len(parent)
        self.parent = parent  # 父节点表
        self.node_state = [(self.FREE, -1) for _ in range(self.n)]  # 节点状态，n个节点，每个节点包含一个锁状态和用户的元组

        self.node_children = collections.defaultdict(list)  # 孩子节点表，建立邻接表
        for x in range(self.n):
            father = parent[x]
            self.node_children[father].append(x)

    def lock(self, num: int, user: int) -> bool:
        if self.node_state[num][0] == self.LOCKED:
            return False
        else:
            self.node_state[num] = (self.LOCKED, user)
            return True

    def unlock(self, num: int, user: int) -> bool:
        if self.node_state[num] == (self.LOCKED, user):
            self.node_state[num] = (self.FREE, -1)
            return True
        else:
            return False

    def upgrade(self, num: int, user: int) -> bool:
        # print(self.node_state)

        # ----当前节点必须是闲的
        if self.node_state[num][0] == self.LOCKED:
            return False
        # ----祖先节点没有上锁的
        p = self.parent[num]
        while p != -1:
            if self.node_state[p][0] == self.LOCKED:
                return False
            p = self.parent[p]
        # ----子孙节点，至少有一个上锁
        find = False

        def dfs1(x: int) -> None:
            nonlocal find
            for y in self.node_children[x]:
                if self.node_state[y][0] == self.LOCKED:
                    find = True
                    break
                dfs1(y)

        dfs1(num)
        if not find:
            return False
        # ---给当前的上锁
        self.node_state[num] = (self.LOCKED, user)

        def dfs2(x: int) -> None:
            for y in self.node_children[x]:
                self.node_state[y] = (self.FREE, -1)
                dfs2(y)

        dfs2(num)
        return True

# Your LockingTree object will be instantiated and called as such:
# obj = LockingTree(parent)
# param_1 = obj.lock(num,user)
# param_2 = obj.unlock(num,user)
# param_3 = obj.upgrade(num,user)
