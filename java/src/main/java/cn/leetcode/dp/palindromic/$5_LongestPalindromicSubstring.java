package cn.leetcode.dp.palindromic;

// 后效性dp
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
                    f[i][j] = false; // 不相等必然不是回文串
                } else {
                    if (j - i <= 2) {
                        f[i][j] = true; // 初始化在两个i=j和j-i=1主对角线
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
