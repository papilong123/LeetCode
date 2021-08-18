package cn.leetcode.dp.stock;

// 卖出股票后有一天冷冻期，交易次数没有限制，卖出股票后，无法在第二天买入股票
public class $309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    // 注意到上面的状态转移方程中，f[i][..] 只与 f[i-1][..] 有关，而与 f[i-2][..] 及之前的所有状态都无关，
    // 因此我们不必存储这些无关的状态。也就是说，我们只需要将 f[i-1][0]，f[i-1][1]，f[i-1][2] 存放在三个变量中，
    // 通过它们计算出 f[i][0]，f[i][1]，f[i][2] 并存回对应的变量，以便于第 i+1 天的状态转移即可。

    public int maxProfitLessConstant(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }

}
