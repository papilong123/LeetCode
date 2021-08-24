from collections import defaultdict
from functools import lru_cache
from typing import List


def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
    connect = defaultdict(dict)
    inf = 1e9+7
    for a, b, c in flights:  # 创建邻接矩阵
        connect[a][b] = c

    @lru_cache(None)
    def dfs(city, remain):
        if city == dst:  # 到达目标城市，返回零
            return 0
        if not remain:  # 不是终点也不能再动了，返回inf
            return inf
        remain -= 1  # 剩下城市数量减一
        ans = inf
        for nxt in connect[city]:
            ans = min(ans, dfs(nxt, remain) + connect[city][nxt])
        return ans

    res = dfs(src, k + 1)
    return res if res != inf else -1
