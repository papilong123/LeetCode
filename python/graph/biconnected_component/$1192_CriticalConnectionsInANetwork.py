from collections import defaultdict
from typing import List


# 标签 双连通分量
# https://www.bilibili.com/video/BV15t4y197eq/
# 有向图tarjan强连通分量算法, time complexity O(V+E)
class Solution:
    def __init__(self):
        self.T = 1

    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        adjvex = defaultdict(set)
        for u, v in connections:  # 建立邻接矩阵
            adjvex[u].add(v)
            adjvex[v].add(u)

        dfn = [0] * n  # dfs访问中的实际时间
        low = [0] * n  # dfs中通过无向边可以向前回溯到的最早的时间点

        def tarjan(x: int, parent: int) -> None:  # 环上的所有点中ID最小的作为环的共用ID，变相合并成一个点
            dfn[x] = self.T
            low[x] = self.T
            self.T += 1

            for y in adjvex[x]:
                if y == parent:  # 跳过父节点
                    continue

                if dfn[y] == 0:  # 还没访问过
                    tarjan(y, x)  # 先访问y，访问了才能计算
                    low[x] = min(low[x], low[y])

                    if low[y] > dfn[x]:  # x 和 y不在一个强连通分量
                        res.append([x, y])

                elif dfn[y] != 0:  # 访问过了
                    low[x] = min(low[x], dfn[y])

        res = []
        tarjan(0, -1)
        return res
