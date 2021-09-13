class Solution:
    # 区间dp
    def checkValidString(self, s: str) -> bool:
        # dp[i][j]表示字符串s从i到j的字串是否为有效的括号字符串，其中0<=i<=j<n
        # 动态规划的边界情况是子串的长度为 1 或 2 的情况。
        # 当子串的长度为 1 时，只有当该字符是 ‘*’ 时，才是有效的括号字符串，此时子串可以看成空字符串；
        # 当子串的长度为 2 时，只有当两个字符是 "()",“(*",“*)",“**" 中的一种情况时，才是有效的括号字符串，此时子串可以看成 “()"。
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        for i in range(n):
            if s[i] == '*':  # 星号一定是有效的
                dp[i][i] = True
        for i in range(1, n):
            c1 = s[i - 1]
            c2 = s[i]
            dp[i - 1][i] = (c1 == '(' or c1 == '*') and (c2 == ')' or c2 == '*')
        for i in range(n - 3, -1, -1):  # i从后往前n-3长度为3开始
            c1 = s[i]
            for j in range(i + 2, n):
                c2 = s[j]
                if (c1 == '(' or c1 == '*') and (c2 == ')' or c2 == '*'):  # 如果两边能匹配，则从中间的dp[i+1][j-1]转移而来
                    dp[i][j] = dp[i + 1][j - 1]
                for k in range(i, j):  # 从dp[i][k] 和 dp[k+1][j]两段拼凑而来，i<=k<j
                    if dp[i][j]:
                        break
                    dp[i][j] = dp[i][k] and dp[k + 1][j]
        return dp[0][n - 1]
