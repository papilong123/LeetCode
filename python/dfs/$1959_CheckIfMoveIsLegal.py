from typing import List


class Solution:
    def checkMove(self, board: List[List[str]], rMove: int, cMove: int, color: str) -> bool:
        # 判断每个方向是否存在以操作位置为起点的好线段
        def check(dx: int, dy: int) -> bool:
            x, y = rMove + dx, cMove + dy
            step = 1   # 当前遍历到的节点序号
            while 0 <= x < 8 and 0 <= y < 8:
                if step == 1:
                    # 第一个点必须为相反颜色
                    if board[x][y] == "." or board[x][y] == color:
                        return False
                else:
                    # 好线段中不应存在空格子
                    if board[x][y] == ".":
                        return False
                    # 遍历到好线段的终点，返回 true
                    if board[x][y] == color:
                        return True
                step += 1
                x += dx
                y += dy
            # 不存在符合要求的好线段
            return False

        # 从 x 轴正方向开始逆时针枚举 8 个方向
        dx = [1, 1, 0, -1, -1, -1, 0, 1]   # 行改变量
        dy = [0, 1, 1, 1, 0, -1, -1, -1]   # 列改变量
        for k in range(8):
            if check(dx[k], dy[k]):
                return True
        return False
