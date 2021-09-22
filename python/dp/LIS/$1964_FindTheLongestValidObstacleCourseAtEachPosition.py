from bisect import bisect_right
from typing import List


class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: List[int]) -> List[int]:
        d, ans = [], []
        for ob in obstacles:
            # 这里需要改成 >=
            if not d or ob >= d[-1]:
                d.append(ob)
                ans.append(len(d))
            else:
                # 将 300 题解中的二分查找改为 API 调用使得代码更加直观
                # 如果是最长严格递增子序列，这里是 bisect_left
                # 如果是最长递增子序列，这里是 bisect_right
                loc = bisect_right(d, ob)
                ans.append(loc + 1)
                d[loc] = ob

        return ans
