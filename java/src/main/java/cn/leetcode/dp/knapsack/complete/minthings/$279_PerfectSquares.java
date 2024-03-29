package cn.leetcode.dp.knapsack.complete.minthings;

public class $279_PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        $279_PerfectSquares solution = new $279_PerfectSquares();
        int ans = solution.numSquares(12);
        System.out.println(ans);
    }
}
