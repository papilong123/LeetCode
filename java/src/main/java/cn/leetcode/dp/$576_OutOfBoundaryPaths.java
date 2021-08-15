package cn.leetcode.dp;

public class $576_OutOfBoundaryPaths {
    int mod = (int) 1e9 + 7;
    int m, n, N;

    public int findPaths(int _m, int _n, int _N, int _i, int _j) {
        m = _m;
        n = _n;
        N = _N;

        // f[i][j] 代表从 idx 为 i 的位置出发，移动步数不超过 j 的路径数量
        int[][] f = new int[m * n][N + 1];

        // 初始化边缘格子的路径数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) add(i, j, f);
                if (i == m - 1) add(i, j, f);
                if (j == 0) add(i, j, f);
                if (j == n - 1) add(i, j, f);
            }
        }

        // 定义可移动的四个方向
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 从小到大枚举「可移动步数」
        for (int step = 1; step <= N; step++) {
            // 枚举所有的「位置」
            for (int k = 0; k < m * n; k++) {
                int x = parseIdx(k)[0], y = parseIdx(k)[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    // 如果位置有「相邻格子」，则「相邻格子」参与状态转移
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        f[k][step] += f[getIndex(nx, ny)][step - 1];
                        f[k][step] %= mod;
                    }
                }
            }
        }

        // 最终结果为从起始点触发，最大移动步数不超 N 的路径数量
        return f[getIndex(_i, _j)][N];
    }

    // 为每个「边缘」格子，添加一条路径
    void add(int x, int y, int[][] f) {
        int idx = getIndex(x, y);
        for (int step = 1; step <= N; step++) {
            f[idx][step]++;
        }
    }

    // 将 (x, y) 转换为 index
    int getIndex(int x, int y) {
        return x * n + y;
    }

    // 将 index 解析回 (x, y)
    int[] parseIdx(int idx) {
        return new int[]{idx / n, idx % n};
    }

}
