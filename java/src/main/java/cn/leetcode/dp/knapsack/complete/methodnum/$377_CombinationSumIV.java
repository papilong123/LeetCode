package cn.leetcode.dp.knapsack.complete.methodnum;

public class $377_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 求排列，外层是背包，内层是物品
        // 如果把遍历nums（物品）放在外循环，遍历target的作为内循环的话，
        // 举一个例子：计算dp[4]的时候，结果集只有 {1,3} 这样的集合，不会有{3,1}这样的集合，因为nums遍历放在外层，3只能出现在1后面！
        for (int i = 0; i <= target; i++) { // 遍历背包
            for (int j = 0; j < nums.length; j++) { // 遍历物品
                if (i - nums[j] >= 0) { // 背包容量能放下物品
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
