from typing import List

from segment_tree.binary_indexed_tree.BinaryIndexedTree import BinaryIndexedTree


class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        total = 10 ** 4
        n = len(nums)
        ans = [0] * n
        tree = BinaryIndexedTree(2 * total + 1)
        for i in range(n - 1, -1, -1):
            tree.update(nums[i] + 1 + total, 1)
            t = tree.query(nums[i] + total)
            ans[i] = t
        return ans
