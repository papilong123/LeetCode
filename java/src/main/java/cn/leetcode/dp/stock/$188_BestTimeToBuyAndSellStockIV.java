package cn.leetcode.dp.stock;

// 最多卖出k次，和第三题是同一题
public class $188_BestTimeToBuyAndSellStockIV {
    // 记录第i次买入后能剩下的最大利润，以此为基础求出第i次卖出后的最大利润
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        int[] sell = new int[k + 1];

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                // buy[i] = Max(在这次之前的第i次买入后能剩下的最大利润， 这次买入后能剩下的最大利润 = 之前第i-1次的最大利润 - 这次买入的花费)
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                // sell[i] = Max(之前的i-1次买卖后的最大利润，第i次买入后剩下的最大利润 + 这次卖出的利润）
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}
