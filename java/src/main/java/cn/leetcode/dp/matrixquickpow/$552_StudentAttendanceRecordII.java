package cn.leetcode.dp.matrixquickpow;

import java.util.Arrays;

// https://leetcODe-cn.com/problems/student-attendance-record-ii/solution/xue-sheng-chu-qin-ji-lu-ii-by-leetcODe/
public class $552_StudentAttendanceRecordII {
    long M = 1000000007;
    int MOD = 1000000007;

    // 方法 1：暴力[Time Limit Exceeded]
    int count;

    public int checkRecordBruteForce(int n) {
        count = 0;
        gen("", n);
        return count;
    }

    private void gen(String s, int n) {
        if (n == 0 && check(s))
            count = (count + 1) % MOD;
        else if (n > 0) {
            gen(s + "A", n - 1);
            gen(s + "P", n - 1);
            gen(s + "L", n - 1);
        }
    }

    private boolean check(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count < 2; i++)
            if (s.charAt(i) == 'A')
                count++;
        return s.length() > 0 && count < 2 && !s.contains("LLL");
    }

    // 方法 2：使用递归公式 [Time Limit Exceeded]
    public int checkRecordRecursion(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++)
            f[i] = func(i);
        int sum = func(n);
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % MOD;
        }
        return sum % MOD;
    }

    private int func(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 2;
        if (n == 2)
            return 4;
        if (n == 3)
            return 7;
        return (2 * func(n - 1) - func(n - 4)) % MOD;
    }

    // 方法 3：使用动态规划 [Accepted]
    public int checkRecordDp(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M; // 这里加M难道是防止为负值？
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int) (sum % M);
    }

    // 方法 4：常数空间的动态规划 [Accepted]
    public int checkRecordDpConstant(int n) {
        long a0l0 = 1;
        long a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i < n; i++) {
            long new_a0l0 = (a0l0 + a0l1 + a0l2) % M;
            long new_a0l1 = a0l0;
            long new_a0l2 = a0l1;
            long new_a1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M;
            long new_a1l1 = a1l0;
            long new_a1l2 = a1l1;
            a0l0 = new_a0l0;
            a0l1 = new_a0l1;
            a0l2 = new_a0l2;
            a1l0 = new_a1l0;
            a1l1 = new_a1l1;
            a1l2 = new_a1l2;
        }
        return (int) ((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M);
    }

    // 方法 5：使用更少的变量 [Accepted]
    public int checkRecordLessConstant(int n) {
        long a0l0 = 1, a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i <= n; i++) {
            long a0l0_ = (a0l0 + a0l1 + a0l2) % M;
            a0l2 = a0l1;
            a0l1 = a0l0;
            a0l0 = a0l0_;
            long a1l0_ = (a0l0 + a1l0 + a1l1 + a1l2) % M;
            a1l2 = a1l1;
            a1l1 = a1l0;
            a1l0 = a1l0_;
        }
        return (int) a1l0;
    }

    // 官方第二次修改的两种解法
    // 方法一：动态规划，易于理解
    public int checkRecordEasyUnderstandDp(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3]; // 长度，A 的数量，结尾连续 L 的数量
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 以 P 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // 以 L 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }

    // 方法二：矩阵快速幂,时间复杂度降低到log(n)
    public int checkRecord(int n) {
        long[][] mat = {{1, 1, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0}};
        long[][] res = pow(mat, n);
        long sum = Arrays.stream(res[0]).sum();
        return (int) (sum % MOD);
    }

    public long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, mat);
            }
            n >>= 1;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        int rows = a.length, columns = b[0].length, temp = b.length;
        long[][] c = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < temp; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int ans = new $552_StudentAttendanceRecordII().checkRecordDp(5);
        System.out.println(ans);
    }
}
