package cn.leetcode.dp.knapsack.complete.methodnum;

public class $70_ClimbingStairs {
    // 1阶，2阶，m阶就是物品，楼顶就是背包。 每一阶可以重复使用，例如跳了1阶，还可以继续跳1阶。
    // 问跳到楼顶有几种方法其实就是问装满背包有几种方法。 此时大家应该发现这就是一个完全背包问题了！
    public int climbStairs(int n) {

        // m表示最多可以爬m个台阶，代码中把m改成2就是本题70.爬楼梯可以AC的代码了
        int m = 2;

        // 1. 确定dp数组以及下标的含义
        // dp[i]：爬到有i个台阶的楼顶，有dp[i]种方法。
        int[] dp = new int[n + 1];

        // 3. dp数组如何初始化
        // 既然递归公式是 dp[i] += dp[i - j]，那么dp[0] 一定为1，dp[0]是递归中一切数值的基础所在，如果dp[0]是0的话，其他数值都是0了。
        // 下标非0的dp[i]初始化为0，因为dp[i]是靠dp[i-j]累计上来的，dp[i]本身为0这样才不会影响结果
        dp[0] = 1;

        // 2. 确定递推公式
        // 求装满背包有几种方法，递推公式一般都是dp[i] += dp[i - nums[j]];
        // 本题呢，dp[i]有几种来源，dp[i - 1]，dp[i - 2]，dp[i - 3] 等等，即：dp[i - j]
        // 那么递推公式为：dp[i] += dp[i - j]

        // 4. 确定遍历顺序
        // 这是背包里求排列问题，即：1、2 步  和 2、1 步都是上三个台阶，但是这两种方法不！
        // 所以需将target放在外循环，将nums放在内循环。
        // 每一步可以走多次，这是完全背包，内循环需要从前向后遍历。
        for (int i = 1; i <= n; i++) { // 遍历背包
            for (int j = 1; j <= m; j++) { // 遍历物品
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    public int climbStairsEasyUnderstand(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
