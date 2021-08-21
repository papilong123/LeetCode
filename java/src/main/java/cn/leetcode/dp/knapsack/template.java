package cn.leetcode.dp.knapsack;

public class template {
    // 0-1背包问题母代码(二维)
    public void bag2d() {
        int[] weight = {1, 3, 4};   //各个物品的重量
        int[] value = {15, 20, 30}; //对应的价值
        int bagWeight = 4;          //背包最大能放下多少重的物品

        // 二维数组：状态定义:dp[i][j]表示从0-i个物品中选择不超过j重量的物品的最大价值
        int[][] dp = new int[weight.length + 1][bagWeight + 1];

        // 初始化:第一列都是0，第一行表示只选取0号物品最大价值
        for (int j = bagWeight; j >= weight[0]; j--)
            dp[0][j] = dp[0][j - weight[0]] + value[0];

        // weight数组的大小 就是物品个数
        for (int i = 1; i < weight.length; i++) // 遍历物品(第0个物品已经初始化)
        {
            for (int j = 0; j <= bagWeight; j++) // 遍历背包容量
            {
                if (j < weight[i])           //背包容量已经不足以拿第i个物品了
                    dp[i][j] = dp[i - 1][j]; //最大价值就是拿第i-1个物品的最大价值
                    //背包容量足够拿第i个物品,可拿可不拿：拿了最大价值是前i-1个物品扣除第i个物品的 重量的最大价值加上i个物品的价值
                    //不拿就是前i-1个物品的最大价值,两者进行比较取较大的
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
    }

    // 二维代码可以进行优化，去除选取物品的那一层，简化为一维背包
    // 一维
    // 状态定义：dp[j]表示容量为j的背包能放下东西的最大价值
    public void bag1d() {
        int[] weight = {1, 3, 4};   //各个物品的重量
        int[] value = {15, 20, 30}; //对应的价值
        int bagWeight = 4;          //背包最大能放下多少重的物品

        // 初始化
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = bagWeight; j >= weight[i]; j--) {  // 遍历背包容量(一定要逆序)
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]); //不取或者取第i个
            }
        }
    }

    // 首先是背包分类的模板：
    // 1、0/1背包：外循环nums,内循环target,target倒序且target>=nums[i];
    // 2、完全背包：外循环nums,内循环target,target正序且target>=nums[i];
    // 3、组合背包：外循环target,内循环nums,target正序且target>=nums[i];
    // 4、分组背包：这个比较特殊，需要三重循环：外循环背包bags,内部两层循环根据题目的要求转化为1,2,3三种背包类型的模板
    //
    // 然后是问题分类的模板：
    // 1、最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1)或dp[i] = max/min(dp[i], dp[i-num]+nums);
    // 2、存在问题(bool)：dp[i]=dp[i]||dp[i-num];
    // 3、组合问题：dp[i]+=dp[i-num];
}
