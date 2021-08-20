package cn.leetcode.dp;

public class $276_PaintFence {
    public int numWays(int n, int k) {
        //每个栅栏都有两种状态，和前一种颜色一样或者不一样，
        // 规定0为颜色一样，1为颜色不一样
        // dp[i][0]表示与上一个颜色一样，
        // dp[i][1]表示与上一个颜色不一样

        // 状态转移方程也很容易写出来：
        // dp[i][0] = dp[i - 1][1];
        // dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        // 最结果为dp[n - 1][0] + dp[n - 1][1]
        if (k == 1) return n > 2 ? 0 : 1;
        if (n <= 2) return (int) Math.pow(k, n);
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 状态 0 表示与上一个颜色相同
        dp[0][1] = k; // 状态 1 表示与上一个颜色不同
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        }
        return dp[n - 1][0] + dp[n - 1][1];

    }
}
