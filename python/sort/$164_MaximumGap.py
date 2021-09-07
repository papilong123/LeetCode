from typing import List


class Solution:
    def maximumGap(self, nums: List[int], radix=10) -> int:
        n = len(nums)
        if n < 2:
            return 0

        placement = 1
        max_digit = max(nums)
        while placement <= max_digit:
            buckets = [[] for _ in range(radix)]
            for i in nums:
                tmp = int((i / placement) % radix)
                buckets[tmp].append(i)
            a = 0
            for b in range(radix):
                for i in buckets[b]:
                    nums[a] = i
                    a += 1
            placement *= radix

        res = 0
        for i in range(n - 1):
            if nums[i + 1] - nums[i] > res:
                res = nums[i + 1] - nums[i]
        return res
