package cn.leetcode.dp;

import java.util.ArrayList;

public class $256_PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        int[][] f = new int[n][m];
        System.arraycopy(costs[0], 0, f[0], 0, m);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int k = 0; k < m; k++) {
                    if (j == k) continue;
                    arr.add(f[i - 1][k]);
                }

                int minVal = arr.stream().mapToInt(o -> o).min().orElse(Integer.MAX_VALUE);
                f[i][j] = minVal + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 3}, {2, 9, 4}};
        int res = new $256_PaintHouse().minCost(matrix);
        System.out.println(res);
    }

}
