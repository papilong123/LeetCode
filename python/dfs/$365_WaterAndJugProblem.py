class Solution:
    def __init__(self):
        self.seen = set()  # 用一个哈希集合（HashSet）存储所有已经搜索过的 remain_x, remain_y 状态，保证每个状态至多只被搜索一次。

    def canMeasureWater(self, x: int, y: int, z: int) -> bool:
        stack = [(0, 0)]  # 刚开始两个空水壶
        while stack:
            remain_x, remain_y = stack.pop()
            if remain_x == z or remain_y == z or remain_x + remain_y == z:  # 单个水和或者两个水壶的和等于目标值，递归出口
                return True
            if (remain_x, remain_y) in self.seen:  # 访问过，跳过，继续出栈
                continue
            self.seen.add((remain_x, remain_y))
            # 把 X 壶灌满。
            stack.append((x, remain_y))
            # 把 Y 壶灌满。
            stack.append((remain_x, y))
            # 把 X 壶倒空。
            stack.append((0, remain_y))
            # 把 Y 壶倒空。
            stack.append((remain_x, 0))
            # 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.append((remain_x - min(remain_x, y - remain_y), remain_y + min(remain_x, y - remain_y)))
            # 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.append((remain_x + min(remain_y, x - remain_x), remain_y - min(remain_y, x - remain_x)))
        return False


res = Solution().canMeasureWater(5, 9, 8)
print(res)
