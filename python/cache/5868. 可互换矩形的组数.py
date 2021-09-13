from fractions import Fraction
from collections import Counter
from typing import List


class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        cnt = Counter()
        for w, h in rectangles:
            cnt[Fraction(w, h)] += 1
        ans = 0
        for value in cnt.values():
            ans += value * (value - 1) // 2
        return ans
