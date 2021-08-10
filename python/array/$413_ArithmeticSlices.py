from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        ans, t = 0, 0
        d = nums[1] - nums[0]
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == d:
                t += 1
            else:
                t = 0
                d = nums[i] - nums[i-1]
            ans += t
        return ans


res = Solution().numberOfArithmeticSlices([2,1,3,4,2,3])
print()
