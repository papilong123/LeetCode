class Solution:
    # n根长度不同的木棍的排列，从左侧看恰好看到k根木棍，满足条件的排列有多少种
    # 第一类斯特林数
    def rearrangeSticks(self, n: int, k: int) -> int:
        # f(i, j) 表示长度为 1,2,⋯,i 的木棍且可以可以看到其中的 j 根木棍的方案数
        mod = 10 ** 9 + 7

        # 0根木棍看到0根木棍的排列数为1，0根木棍看到[1,k]根木棍的排列数为0
        f = [1] + [0] * k
        for i in range(1, n + 1):
            g = [0] * (k + 1)
            for j in range(1, k + 1):
                g[j] = (f[j] * (i - 1) + f[j - 1]) % mod
            f = g

        return f[k]
