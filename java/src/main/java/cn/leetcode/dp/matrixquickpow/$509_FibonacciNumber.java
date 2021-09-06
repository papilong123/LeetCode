package cn.leetcode.dp.matrixquickpow;

public class $509_FibonacciNumber {
    int mod = (int) 1e9 + 7;

    long[][] mul(long[][] a, long[][] b) {
        int r = a.length, c = b[0].length, z = b.length;
        long[][] ans = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= mod;
                }
            }
        }
        return ans;
    }

    public int fib(int n) {
        if (n <= 1) return n;
        long[][] mat = new long[][]{
                {1, 1},
                {1, 0}
        };
        long[][] ans = new long[][]{
                {1},
                {0}
        };
        int x = n - 1;
        while (x != 0) {
            if ((x & 1) != 0) ans = mul(mat, ans);
            mat = mul(mat, mat);
            x >>= 1;
        }
        return (int) (ans[0][0] % mod);
    }


    public static void main(String[] args) {
        int res = new $509_FibonacciNumber().fib(3);
        System.out.println(res);
    }
}
