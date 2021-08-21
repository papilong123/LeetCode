from typing import List


def maxCoins(nums: List[int]) -> int:
    # f[i][j]表示开区间(i, j)内能拿到的最多的金币

    # k是开区间 (i, j) 最后一个被戳爆的气球
    # (i,j) 开区间得到的金币由 dp[i][k] 和 dp[k][j] 转移得到
    # 因为是最后一个被戳爆的，所以它周边没有球了！只有这个开区间首尾的 i 和 j 了
    # 这就是为什么DP的状态转移方程是只和 i 和 j 位置的数字有关

    # 如果此时选择戳爆气球k，得到的金币数量就是total = f[i][k] + val[i] * val[k] * val[j] + dp[k][j]
    # val[i]表示 i 位置气球的数字, (i,k) 和 (k,j) 也都是开区间
    # 但为什么前后只要加上 dp[i][k] 和 dp[k][j] 的值就行了呀？
    # 因为 k 是最后一个被戳爆的，所以 (i,j) 区间中 k 两边的东西必然是先各自被戳爆了的， 左右两边互不干扰，大家可以细品一下

    # nums首尾添加1，方便处理边界情况
    nums.insert(0, 1)
    nums.insert(len(nums), 1)

    dp = [[0] * (len(nums)) for _ in range(len(nums))]

    def range_best(i, j):
        m = 0
        # k是(i,j)区间内最后一个被戳的气球
        for k in range(i + 1, j):  # k取值在(i,j)开区间中
            # 以下都是开区间(i,k), (k,j)
            left = dp[i][k]
            right = dp[k][j]
            a = left + nums[i] * nums[k] * nums[j] + right
            m = max(m, a)
        dp[i][j] = m

    # 对每一个区间长度进行循环
    for n in range(2, len(nums)):  # 区间长度 #长度从3开始，n从2开始
        # 开区间长度会从3一直到len(nums)
        # 因为这里取的是range，所以最后一个数字是len(nums)-1

        # 对于每一个区间长度，循环区间开头的i
        for i in range(0, len(nums) - n):  # i+n = len(nums)-1

            # 计算这个区间的最多金币
            range_best(i, i + n)

    return dp[0][len(nums) - 1]


nums = [3, 1, 5, 8]
res = maxCoins(nums)
print(res)
