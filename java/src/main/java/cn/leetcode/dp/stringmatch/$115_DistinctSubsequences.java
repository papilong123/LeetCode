package cn.leetcode.dp.stringmatch;

public class $115_DistinctSubsequences {
    // 用s去匹配t
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] f = new int[m + 1][n + 1];
        f[0][0] = 1;
        for (int j = 1; j <= n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    f[i][j] = f[i][j - 1] + f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i][j - 1];
                }
            }
        }
        return f[m][n];
    }
}
