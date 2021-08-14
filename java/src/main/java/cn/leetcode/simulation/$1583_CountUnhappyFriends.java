package cn.leetcode.simulation;

public class $1583_CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        // order[i][j]表示i的亲近元素下标
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                order[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for(int i = 0; i < n/2; i++){
            match[pairs[i][0]] = pairs[i][1];
            match[pairs[i][1]] = pairs[i][0];
        }

        int unhappyCount = 0;
        for(int x = 0; x < n; x++){
            int y = match[x];
            int index = order[x][y];
            for(int i = 0; i < index; i++){
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }
}
