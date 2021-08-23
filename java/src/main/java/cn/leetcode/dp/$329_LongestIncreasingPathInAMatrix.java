package cn.leetcode.dp;


public class $329_LongestIncreasingPathInAMatrix {
    // 上下左右四个方向
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        // 从每一个点出发，往下深搜，看它最远能到哪
        m = matrix.length;
        n = matrix[0].length;

        // 记忆化
        memo = new int[m][n];

        // 每个点都要作为起始点遍历一下
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 已经遍历过的就不用遍历了
                if (memo[i][j] == 0) {
                    ans = Math.max(ans, dfs(matrix, i, j));
                }
                // 这里为什么不用再比较一次 ans 和 memo[i][j]呢？
                // 因为遍历前面节点的时候已经把后面的节点遍历了
                // 说明后面的节点肯定比前面的节点的最长路径短
                // 所以，不用多判断一次了
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {
        // 已经遍历过，直接返回
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // 否则，看四个方向是否有满足条件的节点去扩散
        // 每个节点的初始路径为1
        int ans = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && matrix[nextI][nextJ] > matrix[i][j]) {
                ans = Math.max(ans, dfs(matrix, nextI, nextJ) + 1);
            }
        }

        // 记录到缓存中
        memo[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int res = new $329_LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix);
        System.out.println(res);
    }
}
