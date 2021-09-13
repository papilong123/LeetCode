package cn.leetcode.dp.numberposition;

import java.util.HashMap;

public class $600_NonnegativeIntegersWithoutConsecutiveOnes {
    // 方法一，官方解答
    public int findIntegers(int n) {
        // 预处理第 i 层满二叉树的路径数量
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // pre 记录上一层的根节点值，res 记录最终路径数
        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            // if 语句判断 当前子树是否有右子树
            if ((n & val) != 0) {
                // 有右子树
                n -= val;
                res += dp[i + 1]; // 先将左子树（满二叉树）的路径加到结果中

                // 处理右子树
                if (pre == 1) {
                    // 上一层为 1，之后要处理的右子树根节点肯定也为 1
                    // 此时连续两个 1，不满足题意，直接退出
                    break;
                }
                // 标记当前根节点为 1
                pre = 1;
            } else {
                // 无右子树，此时不能保证左子树是否为满二叉树，所以要在下一层再继续判断
                pre = 0;
            }

            if (i == 0) {  // 叶结点没有子结点且值为0，需要作为特殊情况单独处理。
                ++res;
            }
        }

        return res;
    }

    // 方法二，数位dp模板，来自三叶
    static int N = 50;
    // f[i][j] 为考虑二进制长度为 i，而且最高位为 j（0 or 1）时的合法数个数
    static int[][] f = new int[N][2];

    static {
        f[1][0] = 1;
        f[1][1] = 2;
        for (int i = 1; i < N - 1; i++) {
            f[i + 1][0] = f[i][1];
            f[i + 1][1] = f[i][0] + f[i][1];
        }
    }

    int getLen(int n) {
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) return i;
        }
        return 0;
    }

    public int findIntegersThreeLeaves(int n) {
        if (n == 0) return 1;
        int len = getLen(n);
        int ans = 0, prev = 0;
        for (int i = len; i >= 0; i--) {
            // 当前位是 0 还是 1
            int cur = ((n >> i) & 1);
            // 如果当前位是 1，那么填 0 的话，后面随便填都符合，将方案数累加
            if (cur == 1) ans += f[i + 1][0];
            // 出现连续位为 1，方案数被计算完了
            if (prev == 1 && cur == 1) break;
            prev = cur;
            if (i == 0) ans++;
        }
        return ans;
    }

    // 方法三，记忆化
    HashMap<Integer, Integer> dp = new HashMap<>();

    public int findIntegersMemory(int n) {
        if (n < 4)
            return n < 3 ? n + 1 : n;
        if (dp.containsKey(n))
            return dp.get(n);
        int b = bits(n);
        // 第一位取0的个数
        int res = findIntegersMemory((1 << b) - 1);
        // 根据第二位是不是1判断第一位取1的个数
        res += ((n >> (b - 1)) & 1) == 1 ? findIntegersMemory((1 << (b - 1)) - 1) : findIntegersMemory(n - (1 << b));
        dp.put(n, res);
        return res;
    }

    public int bits(int n) {
        for (int i = 31; i > 0; i--)
            if (((n >> i) & 1) == 1)
                return i;
        return 0;
    }

}
