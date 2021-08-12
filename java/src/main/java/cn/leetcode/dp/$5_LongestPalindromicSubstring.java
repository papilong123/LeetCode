package cn.leetcode.dp;

public class $5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        int maxLen = 1;
        int begin = 0;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    f[i][j] = false;
                } else {
                    if (j - i < 3) {
                        f[i][j] = true;
                    } else {
                        f[i][j] = f[i + 1][j - 1];
                    }
                }

                if (f[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
