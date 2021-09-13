from functools import lru_cache


class Solution:
    def findIntegers(self, n: int) -> int:
        # 预处理第 i 层满二叉树的路径数量
        dp = [0] * 31
        dp[0] = 1
        dp[1] = 1
        for i in range(2, 31):
            dp[i] = dp[i - 1] + dp[i - 2]

        # pre 记录上一层的根节点值，res 记录最终路径数
        pre = 0
        res = 0

        for i in range(29, -1, -1):  # 右边从上到下判断
            val = (1 << i)
            # if 语句判断 当前子树是否有右子树
            if n & val:
                # 有右子树
                n -= val
                res += dp[i + 1]  # 先将左子树（满二叉树）的路径加到结果中
                if pre == 1:
                    # 上一层为 1，之后要处理的右子树根节点肯定也为 1
                    # 此时连续两个 1，不满足题意，直接退出
                    break
                pre = 1
            else:
                # 无右子树，此时不能保证左子树是否为满二叉树，所以要在下一层再继续判断
                pre = 0

            if i == 0:  # 叶结点没有子结点且值为0，需要作为特殊情况单独处理。
                res += 1

        return res

    @lru_cache(None)
    def findIntegersMemory(self, n: int) -> int:
        if n <= 3:
            return n + 1 if n < 3 else n
        bits = len(bin(n)) - 2
        return self.findIntegers((1 << (bits - 1)) - 1) + (
            self.findIntegers((1 << (bits - 2)) - 1) if (n >> (bits - 2)) & 1 else self.findIntegers(
                n - (1 << (bits - 1))))
