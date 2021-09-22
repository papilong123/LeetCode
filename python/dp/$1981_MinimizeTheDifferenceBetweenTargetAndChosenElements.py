from functools import lru_cache


class Solution:
    ans = float('inf')

    def minimizeTheDifference(self, mat, target: int) -> int:
        m, n = len(mat), len(mat[0])
        for i in mat:
            i.sort()  # 每一行排序进行剪枝

        @lru_cache(None)
        def dfs(cur, cum):
            if cur == m:
                self.ans = min(self.ans, abs(cum - target))
                return
            for i in range(n):
                res = cum + mat[cur][i]
                if res >= target and res - target >= self.ans:  # 前缀和超过target并且前缀和与target差值大于当前最优解
                    return
                dfs(cur + 1, res)

        dfs(0, 0)
        return self.ans
