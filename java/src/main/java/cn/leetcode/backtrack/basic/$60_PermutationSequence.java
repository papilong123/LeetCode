package cn.leetcode.backtrack.basic;

public class $60_PermutationSequence {
    private boolean[] used;
    private int[] factorial;
    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);

        used = new boolean[n + 1];

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }

    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        String ans = new $60_PermutationSequence().getPermutation(14, 21533);
        System.out.println(ans);
    }
}
