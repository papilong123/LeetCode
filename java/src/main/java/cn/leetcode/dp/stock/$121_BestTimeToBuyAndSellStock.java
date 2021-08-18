package cn.leetcode.dp.stock;

// 只能完成一笔交易
public class $121_BestTimeToBuyAndSellStock {
    // 方法一：暴力法
    public int maxProfitBruteForce(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    // 方法二：一次遍历 维持一个股票最小价格和当前天能获得的最大利润
    public int maxProfitTraversalOnce(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            }
            maxprofit = Math.max(maxprofit, price - minprice);
        }
        return maxprofit;
    }

}
