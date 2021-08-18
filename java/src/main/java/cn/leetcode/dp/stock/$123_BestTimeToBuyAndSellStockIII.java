package cn.leetcode.dp.stock;

// 最多可以完成两笔交易
public class $123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        // 通俗易懂的动态规划解法
        // 一天结束时，可能有持股、可能未持股、可能卖出过1次、可能卖出过2次、也可能未卖出过
        // 所以定义状态转移数组dp[天数][当前是否持股][卖出的次数]
        int len = prices.length;
        int[][][] dp = new int[len][2][3];

        // 第一天休息
        dp[0][0][0] = 0;
        // 第一天买入
        dp[0][1][0] = -prices[0];
        // 第一天不可能已经有卖出
        // 这里为什么+100000， 因为下面dp[i-1][0][1] - prices[i]可能会溢出，这是根据测试用例调整的
        dp[0][0][1] = Integer.MIN_VALUE + 100000;
        dp[0][0][2] = Integer.MIN_VALUE;
        // 第一天不可能已经卖出
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][1][2] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            // 未持股，未卖出过，说明从未进行过买卖
            dp[i][0][0] = 0;
            // 未持股，卖出过1次，可能是今天卖的，可能是之前卖的
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            // 未持股，卖出过2次，可能是今天卖的，可能是之前卖的
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            // 持股，未卖出过，可能是今天买的，可能是之前买的
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            // 持股，卖出过1次，可能是今天买的，可能是之前买的
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            // 持股，卖出过2次，不可能
            dp[i][1][2] = Integer.MIN_VALUE;
        }
        return Math.max(Math.max(dp[len - 1][0][1], dp[len - 1][0][2]), 0);
    }
}
