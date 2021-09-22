from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # 维护一个最长递增子序列
        d = []
        for num in nums:
            if not d or num > d[-1]:
                d.append(num)
            else:
                l, r = 0, len(d) - 1
                pos = r
                while l <= r:
                    mid = (l + r) // 2
                    if d[mid] >= num:
                        pos = mid
                        r = mid - 1
                    else:
                        l = mid + 1
                d[pos] = num
        return len(d)

    def lengthOfLISRaw(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp = []
        for i in range(len(nums)):
            dp.append(1)
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)
