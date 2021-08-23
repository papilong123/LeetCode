from typing import List


class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        Row = len(matrix)
        Col = len(matrix)

        tot_sum = 0
        cnt = 0
        min_ = float('inf')
        for r in range(Row):
            for c in range(Col):
                tot_sum += abs(matrix[r][c])
                if matrix[r][c] < 0:
                    cnt += 1
                min_ = min(min_, abs(matrix[r][c]))
        if cnt % 2 == 0:
            return tot_sum
        else:
            return tot_sum - 2 * min_


mat = [[1, 2, 3], [-1, -2, -3], [1, 2, 3]]
res = Solution().maxMatrixSum(mat)
