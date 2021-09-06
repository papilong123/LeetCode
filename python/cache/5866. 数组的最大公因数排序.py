from typing import List


class Solution:
    # 并查集+分解质因数
    def gcdSort(self, nums: List[int]) -> bool:
        target = sorted(nums)  # 排序
        a = set(nums)  # 集合
        max_v = max(a)  # 最大值
        uf = UnionFind(max_v + 1)  # 并查集，容量为最大值加一
        for i in range(2, max_v + 1):  # 从2一直到最大值
            # 枚举i的倍数
            for j in range(i, max_v + 1, i):
                if j in a:
                    uf.union(j, i)

        for i in range(len(nums)):
            ux, uy = uf.find(nums[i]), uf.find(target[i])
            # 目标位置与当前位置未连通
            if ux != uy:
                return False
        return True


class UnionFind:
    def __init__(self, x) -> None:
        self.uf = [-1] * x

    def find(self, x):
        r = x
        while self.uf[x] >= 0:
            x = self.uf[x]

        while r != x:
            self.uf[r], r = x, self.uf[r]
        return x

    def union(self, x, y):
        ux, uy = self.find(x), self.find(y)
        if ux == uy:
            return
        if self.uf[ux] >= self.uf[uy]:
            self.uf[uy] += self.uf[ux]
            self.uf[ux] = uy
        else:
            self.uf[ux] += self.uf[uy]
            self.uf[uy] = ux
        return
