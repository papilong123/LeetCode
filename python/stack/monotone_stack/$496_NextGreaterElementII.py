from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ret = [-1] * n
        stk = []

        for i in range(n * 2 - 1):  # 搜索2*n-1个元素就够了
            while stk and nums[stk[-1]] < nums[i % n]:  # 模去n
                ret[stk.pop()] = nums[i % n]
            stk.append(i % n)

        return ret
