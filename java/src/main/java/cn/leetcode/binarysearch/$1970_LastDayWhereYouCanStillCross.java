package cn.leetcode.binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class $1970_LastDayWhereYouCanStillCross {
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] mark = new int[row][col];
        for (int i = 0; i < cells.length; i++) {
            mark[cells[i][0] - 1][cells[i][1] - 1] = i + 1;
        }
        int l = 0, r = cells.length;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(mid, mark)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(int mid, int[][] mark) {
        int m = mark.length, n = mark[0].length;
        boolean[][] aross = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            if (mid < mark[0][j]) {
                queue.add(new int[]{0, j});
                aross[0][j] = true;
            }
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            if (arr[0] == m - 1) return true;
            for (int[] dir : dirs) {
                int r = arr[0] + dir[0], c = arr[1] + dir[1];
                if (r >= m || r < 0 || c >= n || c < 0) continue;
                if (aross[r][c] || mark[r][c] <= mid) continue;
                aross[r][c] = true;
                queue.offer(new int[]{r, c});
            }
        }
        return false;
    }
}
