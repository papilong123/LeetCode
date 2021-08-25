package cn.leetcode.graph;

import java.util.Arrays;

public class $787_CheapestFlightsWithinKStops {
    final int INF = 10000 * (100 + 1) + 1;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] f = new int[k + 2][n];
        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(f[i], INF);
        }
        int res = INF;
        f[0][src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                f[i][flight[1]] = Math.min(f[i][flight[1]], f[i - 1][flight[0]] + flight[2]);
            }
            res = Math.min(res, f[i][dst]);
        }
        // 不能到达的情况
        return res == INF ? -1 : res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] mat = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int res = new $787_CheapestFlightsWithinKStops().findCheapestPrice(n, mat, src, dst, k);
        System.out.println(res);
    }
}
