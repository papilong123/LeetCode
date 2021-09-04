from typing import List


class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        stack = []
        max_val = -(10 ** 9 + 7)
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] < max_val:  # 最小值哨兵，只要当前元素小于右边出栈元素的最大值，就判定为存在
                return True
            while stack and stack[-1] < nums[i]:  # 大于栈顶元素，维护一个右边比当前值小的最大值的单增栈
                max_val = max(max_val, stack.pop())  # 每次出栈记录最大值
            stack.append(nums[i])
        return False
