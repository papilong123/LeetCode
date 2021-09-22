from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        box = [set() for _ in range(9)]
        ro = [set() for _ in range(9)]
        co = [set() for _ in range(9)]
        for i in range(81):
            row, col = i // 9, i % 9
            box_index = (row // 3) * 3 + col // 3
            if board[row][col] != '.':
                num = int(board[row][col])
                if num in box[box_index] or num in ro[row] or num in co[col]:
                    return False
                box[box_index].add(num)
                ro[row].add(num)
                co[col].add(num)
        return True
