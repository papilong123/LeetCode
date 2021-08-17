package cn.leetcode.dp.palindromic;

public class $516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        // dp[i][j] 表示：字符区间 s[i..j] 里最长回文子序列的长度
        int[][] dp = new int[n][n];

        // 边界条件，单个字符必然是回文，长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        char[] charArray = s.toCharArray();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (charArray[i] == charArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
