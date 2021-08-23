class Solution:
    def numberOfCombinations(self, num: str) -> int:
        MOD = 1000000007
        N = len(num)
        if num[0] == '0':
            return 0

        dp = [[0] * (N + 1) for _ in range(N)]
        dp[0][1] = 1
        for i in range(1, N):
            dp[i][i + 1] = 1
            for j in range(1, i + 1):
                if num[i - j + 1] != '0':  # 不以零开头

                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD
                    end = i - j  # 上一个数字的最后一位的位置
                    if end >= j - 2 and num[end + 1:i] < num[end - j + 2:end + 1]:  # 当前数字小于上个数字
                        dp[i][j] = (dp[i][j] + dp[end][j - 1]) % MOD
                    if end >= j - 1 and num[end + 1:i + 1] >= num[end - j + 1:end + 1]:  # 当前数字大于等于上个数字
                        dp[i][j] = (dp[i][j] + dp[end][j]) % MOD

                    # end = i - j
                    # if end + 1 < j:
                    #     for k in range(1, end+2):
                    #         dp[i][j] = (dp[i][j] + dp[end][k]) % MOD
                    # else:
                    #     for k in range(1, j):
                    #         dp[i][j] = (dp[i][j] + dp[end][k]) % MOD
                    #     if end >= j-1 and num[end+1:i+1] >= num[end-j+1:end+1]:
                    #         dp[i][j] = (dp[i][j] + dp[end][j]) % MOD
        return (sum(dp[-1])) % MOD


# （一）状态：dp[i][j]
# i: 当前处理的最后一个字符的下标
# j: 当前划分出的最后一个数字的长度
# dp[i][j]表示以第i位结尾，且最后一个数字的长度为j时的种类数
# （二）状态转移方程
# dp[i][j] = dp[i-1][j-1]
# end = i - j
# if end >= j-2 and num[end+1:i] < num[end-j+2:end+1]:
# dp[i][j] = (dp[i][j] + dp[end][j-1]) % MOD
# if end >= j-1 and num[end+1:i+1] >= num[end-j+1:end+1]:
# dp[i][j] = (dp[i][j] + dp[end][j]) % MOD
# 其中end为倒数第二个数字的结尾。（以end结尾，且最后一个数字小于等于（以i结尾且长度为j的数字）的情况都是dp[i][j]的结果，可参考下边注释掉的代码）
# （但那样时间复杂度太高，因而改成了上边这样更好利用了之前的计算结果）(因为dp[i-1][j-1]中也包含了以end结尾且最后一个数字长度小于j-1的情况，
# 故可直接利用这些中间结果，但对于以end结尾且长度为j-1和j的情况是否也包含在dp[i][j]中则需要做特殊处理)
# （三）初始状态
# 参见代码
# （四）返回结果
# sum(dp[-1])%MOD（记得取余。虽然竞赛时前边都取余了但忘了给最后这个取余结果一直有一个用例不过）


num1 = "327845437"
num2 = "094"
num3 = "0"
res = Solution().numberOfCombinations(num1)
print(res)
