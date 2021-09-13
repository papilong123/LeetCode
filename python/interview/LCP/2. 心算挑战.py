import heapq
from typing import List


class Solution:
    def maxmiumScore(self, cards: List[int], cnt: int) -> int:
        cards = [-i for i in cards]
        heapq.heapify(cards)
        _sum = 0
        for i in range(cnt):
            v = -cards.pop()
            _sum += v
        if _sum % 2 == 0:
            return _sum
        while cards:
            val = -cards.pop()
