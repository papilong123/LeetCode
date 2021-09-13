from collections import defaultdict
from typing import List


# 枚举 + 哈希表
class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        ans = 0
        for p in points:
            c = defaultdict(int)
            for q in points:
                c[(p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1])] += 1
            for v in c.values():
                ans += v * (v - 1)
        return ans
