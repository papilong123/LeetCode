# 并查集模板
class UnionFind:
    def __init__(self, n: int):
        self.parent = [-1] * n  # 刚开始指向-1
        self.size = [1] * n  # 当前节点所在集合的大小
        self.n = n  # 整个并查集的大小
        self.setCount = n  # 当前连通分量数目

    # 找到x的根节点，顺便设置x指向x的parent的根节点
    def find(self, x: int) -> int:
        if self.parent[x] != x:  # 如果父节点就是自己，直接返回自己
            self.parent[x] = self.find(self.parent[x])  # 否则设置x指向x的parent的根节点
        return self.parent[x]

    # 合并x，y所处的两个集合
    def unite(self, x: int, y: int) -> bool:
        root_x, root_y = self.find(x), self.find(y)  # 找到x，y的根节点
        if root_x == root_y:  # 根节点是同一个，则未合并，返回False
            return False
        if self.size[root_x] < self.size[root_y]:  # 确保x所在集合大于y所在集合
            root_x, root_y = root_y, root_x
        self.parent[root_y] = root_x  # 小集合的根节点指向大集合的根节点
        self.size[root_x] += self.size[root_y]  # 大集合的尺寸加上小集合的尺寸
        self.setCount -= 1  # 连通分量数减一
        return True

    # 判断是否连接
    def connected(self, x: int, y: int) -> bool:
        root_x, root_y = self.find(x), self.find(y)  # 判断根节点是否相同
        return root_x == root_y
