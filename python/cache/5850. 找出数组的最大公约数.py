from typing import List


class Solution:
    def findGCD(self, nums: List[int]) -> int:
        maxv, minv = max(nums), min(nums)
        res = 1
        for i in range(1, min(maxv, minv) + 1):
            if maxv % i == 0 and minv % i == 0:
                res = max(res, i)
        return res
