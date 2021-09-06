import itertools
from typing import List
from sortedcontainers import SortedSet

from binary_indexed_tree.BinaryIndexedTree import BinaryIndexedTree


class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        preSum = [0] + list(itertools.accumulate(nums))  # 第一位是零的前缀和
        allNumbersTreeSet = SortedSet()  # 相当于Java里的TreeSet
        for x in preSum:
            allNumbersTreeSet.add(x)
            allNumbersTreeSet.add(x - lower)
            allNumbersTreeSet.add(x - upper)

        # 利用哈希表进行离散化
        values = {}
        idx = 0
        for x in allNumbersTreeSet:
            values[x] = idx
            idx += 1

        res = 0
        binaryIndexedTree = BinaryIndexedTree(len(values))
        for i in range(len(preSum)):
            left = values[preSum[i] - upper]
            right = values[preSum[i] - lower]
            res += binaryIndexedTree.query(right + 1) - binaryIndexedTree.query(left)
            binaryIndexedTree.update(values[preSum[i]] + 1, 1)
        return res


ans = Solution().countRangeSum([-2, 5, -1, 4, 6, 8, 4, 6, 3], -2, 2)
print(ans)
