from typing import List


# 去重+排序+滑窗
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        a = list(set(nums))
        a.sort()
        cur = 0
        an = len(a)
        r = 0
        for l in range(an):
            while r + 1 < an and a[r + 1] - a[l] <= n - 1:  # 右边界没有越界且长度符合要求
                r += 1
            cur = max(cur, r - l + 1)

        return n - cur
