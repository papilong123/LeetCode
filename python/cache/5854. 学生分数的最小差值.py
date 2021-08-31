from typing import List


class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        if k == 1:
            return 0
        res = 1e9 + 7
        nums.sort(key=lambda t: -t)
        for i in range(len(nums) - k + 1):
            res = min(res, nums[i] - nums[i + k - 1])
        return res
