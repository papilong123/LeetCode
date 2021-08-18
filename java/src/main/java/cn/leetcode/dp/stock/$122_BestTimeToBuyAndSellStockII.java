package cn.leetcode.dp.stock;

// 可以完成无数笔交易
public class $122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];

        // dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润
        // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）
        f[0][0] = 0; // 第一天手里无股票，获取利润为零
        f[0][1] = -prices[0]; // 第一天手里有股票，但获取利润为负
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]); // 当前天由前一天两种状态而来，i-1天没股票不买，或者有股票卖
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]); // i-1天有股票不卖，或者没股票买股票
        }
        return f[n - 1][0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int ans = new $122_BestTimeToBuyAndSellStockII().maxProfit(nums);
        System.out.println(ans);
    }

}
