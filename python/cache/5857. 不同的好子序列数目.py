class Solution:
    def numberOfUniqueGoodSubsequences(self, s: str) -> int:
        n = len(s)
        dp0, dp1, mod, has0 = 0, 0, 1e9 + 7, 0
        for i in range(n - 1, -1, -1):
            if s[i] == '0':
                has0 = 1
                dp0 = (dp0 + dp1 + 1) % mod
            else:
                dp1 = (dp0 + dp1 + 1) % mod
        return (dp1 + has0) % mod
