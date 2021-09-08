from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        size = len(heights)
        res = 0

        stack = []

        for i in range(size):
            while stack and heights[i] < heights[stack[-1]]:
                cur_height = heights[stack.pop()]

                while stack and cur_height == heights[stack[-1]]:
                    stack.pop()

                if stack:
                    cur_width = i - stack[-1] - 1
                else:
                    cur_width = i

                res = max(res, cur_height * cur_width)
            stack.append(i)

        while stack:
            cur_height = heights[stack.pop()]
            while stack and cur_height == heights[stack[-1]]:
                stack.pop()

            if stack:
                cur_width = size - stack[-1] - 1
            else:
                cur_width = size
            res = max(res, cur_height * cur_width)

        return res
