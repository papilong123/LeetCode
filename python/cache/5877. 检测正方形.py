import collections
from typing import List


class DetectSquares:

    def __init__(self):
        self.cnt = collections.Counter()

    def add(self, point: List[int]) -> None:
        self.cnt[(point[0], point[1])] += 1

    def count(self, point: List[int]) -> int:
        x, y = point
        ans = 0
        for xi, yi in self.cnt:
            if abs(xi - x) == abs(yi - y) and xi != x:  # 枚举对角线，在对角线上且不是同一个点
                if (xi, y) in self.cnt and (x, yi) in self.cnt:  # 横纵坐标都要在哈希表中，以避免在哈希表内引入值为0的元素
                    ans += self.cnt[(xi, yi)] * self.cnt[(xi, y)] * self.cnt[(x, yi)]  # 利用乘法原理，每个点取一次，得到结果
        return ans


detectSquares = DetectSquares()
detectSquares.add([3, 10])
detectSquares.add([11, 2])
detectSquares.add([3, 2])
detectSquares.count([11, 10])
detectSquares.count([14, 8])
detectSquares.add([11, 2])
detectSquares.count([11, 10])
