from typing import List


class Solution:
    # 差分数组的性质是，当我们希望对原数组的某一个区间 [l,r] 施加一个增量inc时，
    # 差分数组 d 对应的改变是：d[l] 增加 inc，d[r+1] 减少 inc。 这样对于区间的修改就变为了对于两个位置的修改。
    # 并且这种修改是可以叠加的，即当我们多次对原数组的不同区间施加不同的增量，我们只要按规则修改差分数组即可。
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        nums = [0] * n
        for left, right, inc in bookings:
            nums[left - 1] += inc
            if right < n:
                nums[right] -= inc

        for i in range(1, n):
            nums[i] += nums[i - 1]

        return nums


bookings = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
n = 5
Solution().corpFlightBookings(bookings, 5)
