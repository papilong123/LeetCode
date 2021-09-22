import collections
from typing import List


# 动态规划
class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        end_start_tip = collections.defaultdict(list)
        for start, end, tip in rides:
            start -= 1
            end -= 1
            end_start_tip[end].append((start, end - start + tip))

        f = [0] * n
        for i in range(1, n):
            f[i] = f[i - 1]  # 一方面，我们可以不接终点为 i 的乘客，这样有 f[i]=f[i−1]
            for ss, tt in end_start_tip[i]:
                # 另一方面，我们可以接所有终点为 i 的乘客中收益最大的，这样有 f[i]=max(f[start]+end−start+tip)，二者取最大值
                f[i] = max(f[i], f[ss] + tt)
        return f[n - 1]
