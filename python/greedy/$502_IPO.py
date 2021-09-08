import heapq
from typing import List


# 贪心算法，银行家算法
class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        if w >= max(capital):  # 如果当前拥有资金大于等于capital里最大的启动资金，则返回最大k个启动资金的和
            return w + sum(heapq.nlargest(k, profits))

        n = len(profits)
        money = [(capital[i], profits[i]) for i in range(n)]
        money.sort(key=lambda x: x[0])  # 启动资金从小到大排序(启动资金，利润)
        pq = []
        i = 0
        for _ in range(k):
            while i < n and money[i][0] <= w:  # 将小于当前资金的启动资金建立一个利润的最大堆
                heapq.heappush(pq, -money[i][1])
                i += 1

            if pq:
                w -= heapq.heappop(pq)
            else:
                break  # 当前堆为空，直接返回
        return w
