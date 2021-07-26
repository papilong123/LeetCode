from typing import List


class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        return max(self.merge(self.pick_max(nums1, i), self.pick_max(nums2, k - i)) for i in range(k + 1) if
                   i <= len(nums1) and (k - i) <= len(nums2))

    def merge(self, a, b):
        res = []
        while a or b:
            bigger = a if a > b else b
            res.append(bigger.pop(0))
        return res

    def pick_max(self, nums, k):
        stack = []
        drop = len(nums) - k
        for i, num in enumerate(nums):
            while stack and drop and num > stack[-1]:
                stack.pop()
                drop -= 1
            stack.append(num)
        return stack[:k]


Solution().maxNumber([3, 4, 6, 5], [9, 1, 2, 5, 8, 3], 5)
