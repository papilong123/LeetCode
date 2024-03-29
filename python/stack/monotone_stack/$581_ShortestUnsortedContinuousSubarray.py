from typing import List


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        n = len(nums)

        def isSorted() -> bool:
            for i in range(1, n):
                if nums[i - 1] > nums[i]:
                    return False
            return True

        if isSorted():
            return 0

        numsSorted = sorted(nums)
        left = 0
        while nums[left] == numsSorted[left]:
            left += 1

        right = n - 1
        while nums[right] == numsSorted[right]:
            right -= 1

        return right - left + 1
