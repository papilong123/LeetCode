from typing import List


class Solution:
    def firstDayBeenInAllRooms(self, nextVisit: List[int]) -> int:
        n = len(nextVisit)
        dp = [0] * n
        mod = 1e9 + 7
        dp[0] = 1  # 第一天就是1

        for i in range(1, n):
            # dp[i] = (dp[i-1] + 1) + (dp[i-1] - dp[nextVisit[i-1]] + 1)
            dp[i] = int((mod + 2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2) % mod)
        return int((dp[n - 1] - 1 + mod) % mod)


res = Solution().firstDayBeenInAllRooms([0, 0, 2])
print(res)
