package cn.leetcode.interview.meituan_2021_autumn_school_recruitment;

import java.util.Scanner;

public class meituan009_Dectorator {
    static int mod = 998244353;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[][] memo = new Integer[n + 1][m + 1];

        int res = dfs(0, n, m, 0, memo) % mod;

        System.out.println(res % mod);
    }

    static int dfs(int start, int n, int m, int pre, Integer[][] memo) {
        if (start == m) return 1;
        if (memo[pre][start] != null) {
            return memo[pre][start];
        }
        int res = 0, fi = 1;
        // start == 0时, 第一个数从1开始取, 直到 n
        if (start > 0) fi = pre;

        for (int i = fi; i <= n; i += fi) {
            res = (res + dfs(start + 1, n, m, i, memo)) % mod;
        }
        return memo[pre][start] = res;
    }

    // f[i][j] 表示前i个物品, 且第i个物品价格为 j 的数量
    // 初始值 : 第一个物品, 任意价格数量都为1 -> f[1][1 ~ n] = 1;
    // 状态转移 : 我们只需要枚举上一个物品的价格, 由当前物品是上一个物品价格的倍数来得到当前的状态
    public void dp() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int res = 0;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) f[1][i] = 1;

        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= n; k += j) {
                    f[i][k] = (f[i][k] + f[i - 1][j]) % mod;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            res = (res + f[m][i]) % mod;
        }
        System.out.println(res);
    }

}
