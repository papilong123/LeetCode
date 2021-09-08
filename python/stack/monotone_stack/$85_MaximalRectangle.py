import math
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

    def maximalRectangle(self, matrix: List[str]) -> int:
        n = len(matrix)
        if n == 0:
            return 0
        m = len(matrix[0])
        mat = [[0] * m for _ in range(n)]
        # 字符全都变为数值
        for i in range(n):
            for j in range(m):
                mat[i][j] = int(matrix[i][j])

        # 累加每一列
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 1 and i > 0:
                    mat[i][j] = mat[i - 1][j] + 1
        res = -math.inf
        for i in range(n):
            res = max(res, self.largestRectangleArea(mat[i]))
        return res


matrix = ["10100", "10111", "11111", "10010"]
r = Solution().maximalRectangle(matrix)
print(r)
