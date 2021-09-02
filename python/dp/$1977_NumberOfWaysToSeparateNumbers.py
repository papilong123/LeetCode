class Solution:
    def numberOfCombinations(self, num: str) -> int:
        mod = 10 ** 9 + 7
        if num[0] == "0":
            return 0
        n = len(num)

        # 预处理 lcp
        lcp = [[0] * n for _ in range(n)]
        for i in range(n - 1, -1, -1):
            lcp[i][n - 1] = int(num[i] == num[n - 1])
            for j in range(i + 1, n - 1):
                lcp[i][j] = (lcp[i + 1][j + 1] + 1 if num[i] == num[j] else 0)

        # 动态规划
        f = [[0] * n for _ in range(n)]
        # 边界 f[0][..] = 1
        for i in range(n):
            f[0][i] = 1

        for i in range(1, n):
            # 有前导零，无需转移
            if num[i] == "0":
                continue

            # 前缀和
            presum = 0
            for j in range(i, n):
                length = j - i + 1
                f[i][j] = presum % mod
                if i - length >= 0:
                    # 使用 lcp 比较 num(2i-j-1,i-1) 与 num(i,j) 的大小关系
                    if lcp[i - length][i] >= length or num[i - length + lcp[i - length][i]] < num[
                        i + lcp[i - length][i]]:
                        f[i][j] = (f[i][j] + f[i - length][i - 1]) % mod
                    # 更新前缀和
                    presum += f[i - length][i - 1]

        # 最终答案即为所有 f[..][n-1] 的和
        ans = sum(f[i][n - 1] for i in range(n)) % mod
        return ans


res = Solution().numberOfCombinations("9999999999999")
print(res)
