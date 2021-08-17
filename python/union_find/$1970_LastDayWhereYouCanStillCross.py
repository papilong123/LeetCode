from collections import deque
from typing import List

from union_find.template import UnionFind


# 方法一：二分查找 + 广度优先搜索
def latestDayToCross(row: int, col: int, cells: List[List[int]]) -> int:
    left, right, ans = 0, row * col, 0
    while left <= right:
        mid = (left + right) // 2

        grid = [[1] * col for _ in range(row)]
        for x, y in cells[:mid]:
            grid[x - 1][y - 1] = 0

        q = deque()
        for i in range(col):
            if grid[0][i]:
                q.append((0, i))
                grid[0][i] = 0

        found = False
        while q:
            x, y = q.popleft()
            for nx, ny in [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)]:
                if 0 <= nx < row and 0 <= ny < col and grid[nx][ny]:
                    if nx == row - 1:
                        found = True
                        break
                    q.append((nx, ny))
                    grid[nx][ny] = 0

        if found:
            ans = mid
            left = mid + 1
        else:
            right = mid - 1

    return ans


# 方法二：时光倒流 + 并查集
def latestDayToCrossUnionFind(row: int, col: int, cells: List[List[int]]) -> int:
    # 编号为 n 的节点是超级节点 s
    # 编号为 n+1 的节点是超级节点 t
    n = row * col
    uf = UnionFind(n + 2)

    valid = [[0] * col for _ in range(row)]
    ans = 0
    for i in range(n - 1, -1, -1):
        x, y = cells[i][0] - 1, cells[i][1] - 1
        valid[x][y] = 1
        # 并查集是一维的，(x, y) 坐标是二维的，需要进行转换
        idx = x * col + y
        if x - 1 >= 0 and valid[x - 1][y]:
            uf.unite(idx, idx - col)
        if x + 1 < row and valid[x + 1][y]:
            uf.unite(idx, idx + col)
        if y - 1 >= 0 and valid[x][y - 1]:
            uf.unite(idx, idx - 1)
        if y + 1 < col and valid[x][y + 1]:
            uf.unite(idx, idx + 1)
        if x == 0:
            uf.unite(idx, n)
        if x == row - 1:
            uf.unite(idx, n + 1)
        if uf.connected(n, n + 1):
            ans = i
            break

    return ans
