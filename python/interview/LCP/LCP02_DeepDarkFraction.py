from typing import List


# 迭代
class Solution:
    def fraction(self, cont: List[int]) -> List[int]:
        m, n = 0, 1
        for a in cont[::-1]:
            m, n = n, a * n + m  # 这里不用考虑公约数，因为每次计算出来的值是a + 1/b, 化简之后一定是最简分数的形式
        return [n, m]


c = [3, 2, 0, 2]
res = Solution().fraction(c)
print(res)
