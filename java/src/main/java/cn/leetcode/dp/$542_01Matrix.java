package cn.leetcode.dp;

public class $542_01Matrix {
    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        int ni, nj;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    ni = i + dirs[k][0];
                    nj = i + dirs[k][1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[i][j] == 1 && mat[ni][nj] == 0) {
                        dp[i][j] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    ni = i + dirs[k][0];
                    nj = i + dirs[k][1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[ni][nj]) + 1;
                    }
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] res = new $542_01Matrix().updateMatrix(mat);
        System.out.println(res[0][0]);
    }
}
