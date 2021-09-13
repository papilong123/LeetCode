from typing import List


class NumArray:
    def __init__(self, nums: List[int]):
        """ 初始化sum 数组, 从一计数, 0 号不用
        """
        self.tree = [0 for _ in range(len(nums) + 1)]  # 从第一个数计算下标和
        for k in range(1, len(self.tree)):
            self.tree[k] = sum(nums[k - (k & -k):k])  # 原来的nums从0计数, tree从1计数

    def update(self, i: int, val: int) -> None:
        diff = val - self.sumRange(i, i)  # 计算更新的值和原数的差值, i,j从0 计数
        k = i + 1
        while k <= len(self.tree) - 1:
            self.tree[k] += diff
            k += k & -k

    def sumRange(self, i: int, j: int) -> int:
        # i, j 是从 0计数
        if i + 1 == 1:
            return self.sum1k(j + 1)
        else:
            return self.sum1k(j + 1) - self.sum1k(i)

    def sum1k(self, k: int) -> int:
        res = 0
        while k >= 1:
            res += self.tree[k]
            k -= k & -k
        return res
