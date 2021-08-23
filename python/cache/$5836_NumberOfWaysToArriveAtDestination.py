import heapq
from collections import defaultdict
from typing import List


class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        INF = 10 ** 16
        MOD = 10 ** 9 + 7

        adjvex = defaultdict(list)
        for x, y, cost in roads:  # 转换为邻接矩阵
            adjvex[x].append((y, cost))
            adjvex[y].append((x, cost))

        dist, f = [INF] * n, [0] * n
        dist[0], f[0] = 0, 1

        minHeap = []
        heapq.heappush(minHeap, (0, 0))
        while minHeap:
            d, x = heapq.heappop(minHeap)
            if d > dist[x]:
                continue
            for y, cost in adjvex[x]:
                if dist[x] + cost < dist[y]:
                    dist[y] = dist[x] + cost
                    f[y] = f[x]
                    heapq.heappush(minHeap, (dist[y], y))
                elif dist[x] + cost == dist[y]:
                    f[y] += f[x]
        return f[n - 1] % MOD


n = 7
roads = [[0, 6, 7], [0, 1, 2], [1, 2, 3], [1, 3, 3], [6, 3, 3], [3, 5, 1], [6, 5, 1], [2, 5, 1], [0, 4, 5], [4, 6, 2]]
res = Solution().countPaths(n, roads)
print()
