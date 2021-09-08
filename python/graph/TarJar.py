from collections import defaultdict


# 无向图找桥边的Tarjan算法
class TarJar:

    def __init__(self):
        self.find = False
        self.T = 1  # 全局时钟
        self.adjvex = defaultdict(set)
        self.find = False
        self.R, self.C = len(self.adjvex), len(self.adjvex[0])
        self.dfn = [0] * (self.R * self.C)  # dfs中首次访问的实际时间(depth-first number)
        self.low = [0] * (self.R * self.C)  # dfs中通过无向边可以往前回溯到的最早的时间

    def tarjan(self, x: int, parent: int) -> None:
        self.dfn[x] = self.T
        self.low[x] = self.T  # 初始化
        self.T += 1
        child = 0  # 几个儿子
        for y in self.adjvex[x]:
            if self.dfn[y] == 0:  # y还未访问过
                child += 1
                self.tarjan(y, x)  # 继续递归，dfs
                self.low[x] = min(self.low[x], self.low[y])

                if parent == -1 and child >= 2:  # x是root，且有2个以上的孩子 x是root，是割点
                    self.find = True
                elif parent != -1 and self.low[y] >= self.dfn[x]:  # 可以回溯的最早时间点比父节点晚，x就是割点
                    self.find = True
            else:  # y访问过了
                if y != parent:  # 且y不是x的父亲
                    self.low[x] = min(self.low[x], self.dfn[y])
