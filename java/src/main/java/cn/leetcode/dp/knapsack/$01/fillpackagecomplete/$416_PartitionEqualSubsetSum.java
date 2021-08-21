package cn.leetcode.dp.knapsack.$01.fillpackagecomplete;

import java.util.Arrays;

public class $416_PartitionEqualSubsetSum {
    // 这种方法效率低，但是使用了背包的思想
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        // 特判
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        // 1. 确定dp数组以及下标的含义
        // 01背包中，dp[i] 表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
        // dp[i]中的i表示背包内总和
        // 题目中说：每个数组中的元素不会超过 100，数组的大小不会超过 200
        // 那么背包内总和不会大于20000，所以定义一个20000大的数组。
        int[] dp = new int[20001];

        // 2. 确定递推公式
        // 01背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
        // 本题，相当于背包里放入数值，那么物品i的重量是nums[i]，其价值也是nums[i]。
        // 所以递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);

        // 3. dp数组如何初始化
        // 从dp[j]的定义来看，首先dp[0]一定是0。
        // 如果如果题目给的价值都是正整数那么非0下标都初始化为0就可以了，如果题目给的价值有负数，那么非0下标就要初始化为负无穷。
        // 这样才能让dp数组在递归公式的过程中取的最大的价值，而不是被初始值覆盖了。
        // 本题题目中 只包含正整数的非空数组，所以非0下标的元素初始化为0就可以了。
        dp[0] = 0;

        // 4. 确定遍历顺序
        // 如果使用一维dp数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒叙遍历！
        // 开始 01背包
        for (int num : nums) {
            for (int j = target; j >= num; j--) { // 每一个元素一定是不可重复放入，所以从大到小遍历
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }

        return dp[target] == target;
    }

    // 5. 举例推导dp数组
    // dp[i]的数值一定是小于等于i的。
    // 如果dp[i] == i 说明，集合中的子集总和正好可以凑成总和i，理解这一点很重要。
    // 输入[1,5,11,5] 为例
    public static void main(String[] args) {
        int[] nums = {1, 2, 11, 5};
        boolean res = new $416_PartitionEqualSubsetSum().canPartition(nums);
        System.out.println(res);
    }
}
