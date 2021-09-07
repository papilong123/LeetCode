from math import sqrt

import math
import random
from typing import List


class Solution:

    def __init__(self, radius: float, x_center: float, y_center: float):
        self.radius = radius
        self.x_center = x_center
        self.y_center = y_center

    def randPoint(self) -> List[float]:
        theta = random.uniform(0, 2 * math.pi)  # 生成一个[0, 2pi]的角度theta
        r = sqrt(random.uniform(0, 1)) * self.radius  # 随机生成一个[0, 1]范围的值乘以radius得到[0,radius]的r
        return [self.x_center + r * math.sin(theta), self.y_center + r * math.cos(theta)]  # 代入公式

# Your Solution object will be instantiated and called as such:
# obj = Solution(radius, x_center, y_center)
# param_1 = obj.randPoint()
