import collections
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = collections.deque()
        n, m = len(grid), len(grid[0])
        # 将所有的腐烂橘子入队列
        for i, row in enumerate(grid):
            for j, v in enumerate(row):
                if v == 2:
                    q.append((i, j, 0))

        def neighbor(x, y):
            for xx, yy in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)):
                if 0 <= xx < n and 0 <= yy < m:
                    yield xx, yy

        d = 0
        while q:
            i, j, d = q.popleft()
            for nx, ny in neighbor(i, j):
                if grid[nx][ny] == 1:
                    grid[nx][ny] = 2
                    q.append((nx, ny, d + 1))

        return -1 if any(1 in row for row in grid) else d
