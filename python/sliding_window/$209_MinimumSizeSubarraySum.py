from collections import defaultdict
from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        start, end = 0, 0
        counter = defaultdict(int)
        ans, sum = float('inf'), 0
        flag = False
        while end < len(nums):
            sum += nums[end]
            counter[nums[end]] += 1
            end += 1
            while sum >= target:
                flag = True
                ans = min(ans, end - start)
                sum -= nums[start]
                counter[nums[start]] -= 1
                start += 1
        return ans if flag else 0


res = Solution().minSubArrayLen(7, [2, 3, 1, 2, 4, 3])
print()
