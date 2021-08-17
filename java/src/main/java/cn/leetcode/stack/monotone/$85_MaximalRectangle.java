package cn.leetcode.stack.monotone;

class $85_MaximalRectangle {

    public int maximalRectangleStack(char[][] matrix) {
        if (matrix.length == 0) return 0;
        $84_LargestRectangleinHistogram instance = new $84_LargestRectangleinHistogram();
        int[][] m = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    m[i][j] = i == 0 ? 1 : m[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            res = Math.max(res, instance.largestRectangleArea(m[i]));
        }
        return res;
    }

    // 动态规划
    public int maximalRectangle(char[][] matrix) {
        int maxarea = 0;
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxarea;
    }
}
