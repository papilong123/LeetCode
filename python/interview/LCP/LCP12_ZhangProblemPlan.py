from typing import List


# 给定一个数组，将其划分成 M 份，使得每份元素之和最大值最小，每份可以任意减去其中一个元素。
class Solution:
    def minTime(self, time: List[int], m: int) -> int:
        left, right = 0, sum(time)  # 左边从零开始搜索
        while left < right:
            mid = (left + right) >> 1
            if self.check(mid, time, m):
                right = mid
            else:
                left = mid + 1
        return left

    def check(self, limit, cost, day):
        use_day, total_time, max_time = 1, 0, cost[0]
        for i in cost[1:]:
            if total_time + min(max_time, i) <= limit:  # i的左侧区间维护一个最大值
                total_time, max_time = total_time + min(max_time, i), max(max_time, i)  # 维护当前序列的最大值，然后记录删除最大值的结果
            else:
                use_day += 1
                total_time, max_time = 0, i
        return use_day <= day  # 是否可以让每组删除最大值之后，总和都小于等于 t
