from typing import List


class Solution:
    def countSpecialSubsequences(self, nums: List[int]) -> int:
        mod = 10 ** 9 + 7
        f0 = f1 = f2 = 0
        for num in nums:
            if num == 0:
                f0 = (f0 * 2 + 1) % mod
            elif num == 1:
                f1 = (f1 * 2 + f0) % mod
            else:
                f2 = (f2 * 2 + f1) % mod
        return f2
