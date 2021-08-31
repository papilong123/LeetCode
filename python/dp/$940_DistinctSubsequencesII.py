class Solution:
    def distinctSubseqII(self, s: str) -> int:
        # 无字符组成一个空字符串,dp[i]表示第i个字符结尾的不同子序列数
        dp = [1]
        last = {}
        for i, x in enumerate(s):
            dp.append(dp[-1] * 2)
            if x in last:
                dp[-1] -= dp[last[x]]
            last[x] = i

        return (dp[-1] - 1) % (10 ** 9 + 7)


res = Solution().distinctSubseqII("abcabc")
print(res)
