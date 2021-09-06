import copy
from typing import List


class Solution:
    # 下一个最大元素问题
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        stk = []  # 单增栈
        res = copy.copy(prices)
        for i in range(n):
            while stk and stk[-1][0] >= prices[i]:
                cur, cur_idx = stk.pop()
                res[cur_idx] = cur - prices[i]
            stk.append((prices[i], i))  # 值和下标都入栈
        return res
