package cn.leetcode.dp.knapsack.complete.methodnum;

public class $518_CoinChange2 {
    public int change(int amount, int[] coins) {

        // 1. 确定dp数组以及下标的含义
        // dp[j]：凑成总金额j的货币组合数为dp[j]
        int[] dp = new int[amount + 1];

        // 2. 确定递推公式
        // dp[j] （考虑coins[i]的组合总和） 就是所有的dp[j - coins[i]]（不考虑coins[i]）相加。
        // 所以递推公式：dp[j] += dp[j - coins[i]];

        // 3. dp数组如何初始化
        // 首先dp[0]一定要为1，dp[0] = 1是 递归公式的基础。
        // 从dp[i]的含义上来讲就是，凑成总金额0的货币组合数为1。
        // 下标非0的dp[j]初始化为0，这样累计加dp[j - coins[i]]的时候才不会影响真正的dp[j]
        dp[0] = 1;

        // 4. 遍历顺序
        // 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
        // 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
        for (int i = 0; i < coins.length; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
