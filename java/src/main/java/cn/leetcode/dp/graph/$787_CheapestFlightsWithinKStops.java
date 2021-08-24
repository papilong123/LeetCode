package cn.leetcode.dp.graph;

import java.util.Arrays;

public class $787_CheapestFlightsWithinKStops {
    final int INF = 10000 * 101 + 1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {  // 第1次航班到第k+1次航班
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }

    public int findCheapestPrice1d(int n, int[][] flights, int src, int dst, int k) {
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                g[i] = Math.min(g[i], f[j] + cost);
            }
            f = g;
            ans = Math.min(ans, f[dst]);
        }
        return ans == INF ? -1 : ans;
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0, dst = 2, k = 1;
        int res = new $787_CheapestFlightsWithinKStops().findCheapestPrice(n, edges, src, dst, k);
        System.out.println(res);
    }
}
