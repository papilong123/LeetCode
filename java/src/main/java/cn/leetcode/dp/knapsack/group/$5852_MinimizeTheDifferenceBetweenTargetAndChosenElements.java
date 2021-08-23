package cn.leetcode.dp.knapsack.group;

public class $5852_MinimizeTheDifferenceBetweenTargetAndChosenElements {
    // 方法一，01背包
    // 把每一行看成一组，物品的体积就是元素值，物品的价值为 1。这样就转化成了一个分组背包的模型。
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[][] dp = new boolean[mat.length + 1][4900];
        dp[0][0] = true;

        // 设定boolean dp[i][j]的定义为前i行是否可以凑出j的和，其中j的范围为0-4900。
        // 使用动态规划从而计算出dp[mat.length][0]--dp[mat.length][4900]的结果，也就是知道了mat的所有行一共可以累加和出从0-4900的哪些数字。
        // 求组合数，物品在外层
        for (int i = 1; i <= mat.length; i++) {  // 外层物品
            for (int j = 0; j < 4900; j++) {  // 内层背包
                for (int k = 0; k < mat[0].length; k++) {
                    if (j - mat[i - 1][k] >= 0 && dp[i - 1][j - mat[i - 1][k]]) { // 背包能装下，且去掉这个物品时的重量为true
                        dp[i][j] = true;
                        break;  // 能凑出，跳出循环
                    }
                    dp[i][j] = false;
                }
            }
        }

        // 继而遍历这些数字，找出和target最为接近的数字即可。
        int ret = Integer.MAX_VALUE;
        for (int j = 0; j < 4900; j++) {
            if (dp[mat.length][j]) {
                ret = Math.min(Math.abs(target - j), ret);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 13;
        int res = new $5852_MinimizeTheDifferenceBetweenTargetAndChosenElements().minimizeTheDifference(mat, target);
        System.out.println(res);
    }
}
