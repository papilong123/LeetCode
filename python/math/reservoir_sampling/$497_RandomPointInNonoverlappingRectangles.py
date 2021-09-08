import bisect
import random


class Solution:

    def __init__(self, rects):
        # 思路与528题类似，每个矩形包含的点数即为其权重。计算每个矩阵的权重。
        self.w = [0] * len(rects)
        # 因w中元素都初始化为0，计算w[0]的公式也可以使用w[i]=w[i-1] + dots[i]。因w[-1]是0，不影响结果
        # 点数 = (x2 - x1 + 1) * (y2 - y1 + 1)， 需要加1，例如x1=1, x2=5,一共有5个点（5-1+1）
        for i, (x1, y1, x2, y2) in enumerate(rects):
            self.w[i] = self.w[i - 1] + (x2 - x1 + 1) * (y2 - y1 + 1)
        self.rects = rects

    def pick(self):
        # random.randint(1, self.w[-1])：随机抽样
        # 在其中二分查找，确认应插入的位置。_left：当含有相等元素时，插在其左侧
        i = bisect.bisect_left(self.w, random.randint(1, self.w[-1]))
        # 在选中的矩形中随机选择坐标位置
        # 也可以不再使用random库，直接利用i计算出整个矩阵组中的第i个点的位置
        xi = random.randint(self.rects[i][0], self.rects[i][2])
        yi = random.randint(self.rects[i][1], self.rects[i][3])
        return [xi, yi]


# Your Solution object will be instantiated and called as such:
rects = [[[[1, 1, 5, 5]]], [], [], []]
obj = Solution(rects)
param_1 = obj.pick()
