from typing import List, Tuple


class Solution:
    # 时间复杂度O(3^n),空间复杂度O(2^n)
    def minSessions(self, tasks: List[int], sessionTime: int) -> int:
        INF = 10 ** 9
        n = len(tasks)

        # 预处理所有子集的子集和
        state_sum = [0 for _ in range(1 << n)]
        for state in range(1 << n):
            for i in range(n):
                if (state >> i) & 1:
                    state_sum[state] += tasks[i]

        dp = [INF for _ in range(1 << n)]
        dp[0] = 0

        for state in range(1, 1 << n):
            sub = state
            while sub:
                if state_sum[sub] <= sessionTime:
                    dp[state] = min(dp[state], dp[state ^ sub] + 1)  # 求子集的补集

                sub = (sub - 1) & state

        return dp[(1 << n) - 1]

    def minSessionsCompress(self, tasks: List[int], sessionTime: int) -> int:
        n = len(tasks)
        f = [(float("inf"), float("inf"))] * (1 << n)
        f[0] = (1, 0)  # 使用1个工作时间段，当前时间段工作时间为0

        def add(o: Tuple[int, int], x: int) -> Tuple[int, int]:
            if o[1] + x <= sessionTime:
                return o[0], o[1] + x
            return o[0] + 1, x

        for mask in range(1, 1 << n):
            for i in range(n):
                if mask & (1 << i):
                    f[mask] = min(f[mask], add(f[mask ^ (1 << i)], tasks[i]))

        return f[(1 << n) - 1][0]


res = Solution().minSessions([1, 2, 2, 2, 3, 3, 2, 3, 2], 10)
print(res)
