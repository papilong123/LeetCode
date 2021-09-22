from typing import List


# 爬坡法+(二分左查找or随机化查找)
class Solution:
    # bisect_left
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        while l < r:
            mid = l + ((r - l) >> 1)
            if nums[mid] < nums[mid + 1]:  # 由于全都不相等，所以不满足check的条件是nums[mid] < nums[mid + 1]
                l = mid + 1
            else:
                r = mid  # 满足check的条件是nums[mid] >= nums[mid + 1]，实际上没有等于号，测试用例都不相等

        return l


li = [1, 2, 1, 3, 5, 6, 4]
r = Solution().findPeakElement(li)
print(r)
