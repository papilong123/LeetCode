from typing import List


def minCost(self, costs: List[List[int]]) -> int:
    n = len(costs)
    c = len(costs[0])
    f = [[0] * c for _ in range(n)]
    f[0] = costs[0]

    for i in range(1, n):
        for j in range(c):
            cost = []
            for k in range(c):
                if j == k: continue
                cost.append(f[i - 1][k])
            f[i][j] = min(cost) + costs[i][j]

    return min(f[-1])
