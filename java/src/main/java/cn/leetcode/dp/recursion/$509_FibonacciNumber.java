package cn.leetcode.dp.recursion;

public class $509_FibonacciNumber {
    public int fib(int n) {
        if (n < 2) return n;

        int p = 0, q = 1, r = 1;
        for (int i = 2; i <= n; ++i) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }

    public int fibFormula(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    public static void main(String[] args) {
        int res = new $509_FibonacciNumber().fib(3);
        System.out.println(res);
    }
}
