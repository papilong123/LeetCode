package cn.leetcode.dp;

public class $664_StrangePrinter {
    public int strangePrinter(String s) {
        int n = s.length();
//        区间i，j的最少打印次数
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minVal = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minVal = Math.min(minVal, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minVal;
                }
            }
        }

        return f[0][n - 1];
    }
}
