from math import gcd
from typing import List

mod = 10 ** 9 + 7


class Solution:
    def numberOfGoodSubsets(self, nums: List[int]) -> int:
        cnts = [0] * 31
        for n in nums:
            cnts[n] += 1  # 统计词频
        for n in [4, 8, 9, 12, 16, 18, 20, 24, 25, 27, 28]:
            cnts[n] = 0  # 排除掉有多个相同因子的

        huchi = [0] * 31
        for i in range(2, 31):
            for j in range(2, 31):
                if i != j and gcd(i, j) > 1:  # 不相等且最大公因子大于1
                    huchi[i] |= 1 << j

        def dfs(i, chose):  # n表示当前数字，chose的第i位标识是否选择i
            if i == 31:
                return 1 if chose > 0 else 0
            ret = dfs(i + 1, chose)
            if cnts[i] > 0 and huchi[i] & chose == 0:  # 个数大于0且不互斥
                ret += cnts[i] * dfs(i + 1, chose | (1 << i))
            ret %= mod
            return ret

        return dfs(2, 0) * pow(2, cnts[1], mod) % mod  # 1可以选择任意个


res = Solution().numberOfGoodSubsets([4, 2, 3, 15])
print(res)
