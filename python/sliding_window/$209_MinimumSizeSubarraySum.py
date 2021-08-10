from collections import defaultdict
from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left, right = 0, 0
        counter = defaultdict(int)
        ans, _sum = float('inf'), 0
        flag = False
        while right < len(nums):
            _sum += nums[right]
            counter[nums[right]] += 1
            right += 1
            while _sum >= target:
                flag = True
                ans = min(ans, right - left)
                _sum -= nums[left]
                counter[nums[left]] -= 1
                left += 1
        return ans if flag else 0


res = Solution().minSubArrayLen(7, [2, 3, 1, 2, 4, 3])
print()
