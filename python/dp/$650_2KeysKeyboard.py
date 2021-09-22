class Solution:
    # dp + 枚举质因数
    def minSteps(self, n: int) -> int:
        # f[i] 表示打印出 i 个 A 的最少操作次数
        f = [0] * (n + 1)
        for i in range(2, n + 1):  # 2到n
            f[i] = float("inf")
            j = 1
            while j * j <= i:
                if i % j == 0:
                    f[i] = min(f[i], f[j] + i // j)
                    f[i] = min(f[i], f[i // j] + j)
                j += 1

        return f[n]
