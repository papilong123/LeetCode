package cn.leetcode.graph.common;

// 复杂度为O(n^3),多源最短路径使用邻接矩阵

// 此时计算量约为 10^6，可以过。
// 跑一遍 Floyd，可以得到「从任意起点出发，到达任意起点的最短距离」。
// 然后从所有w[k][x]中取max即是「从 k 点出发，到其他点 x 的最短距离的最大值」。
public class Floyd {
    int N = 110, M = 6010;
    // 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
    int[][] w = new int[N][N];
    int INF = 0x3f3f3f3f;
    int n, k;

    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }
        // 最短路
        floyd();
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, w[k][i]);
        }
        return ans >= INF / 2 ? -1 : ans;
    }

    void floyd() {
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                }
            }
        }
    }
}
