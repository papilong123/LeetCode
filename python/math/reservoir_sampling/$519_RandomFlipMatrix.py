import random
from typing import List


class Solution:

    def __init__(self, m: int, n: int):
        self.m = m
        self.n = n
        self.size = m * n
        self.one2zero = {}  # 被翻转的1映射到取代它的0

    def flip(self) -> List[int]:
        random_idx = random.randrange(0, self.size)  # 随机生成一个数在[0, m*n)范围内
        self.size -= 1  # 蓄水池容量减一

        x = self.one2zero.get(random_idx, random_idx)  # 如果没有被被反转过就取他自己，否则取替换自己的0的位置
        tmp = self.one2zero.get(self.size, self.size)  # 如果最后一个元素被替换过，取替换它的0的位置，否则取自己
        self.one2zero[random_idx] = tmp  # 指向size位置或之前替换size位置的0的位置

        return [x // self.n, int(x % self.n)]

    def reset(self) -> None:
        self.one2zero.clear()
        self.size = self.m * self.n


# Your Solution object will be instantiated and called as such:
r = 3
c = 2
obj = Solution(r, c)
param_1 = obj.flip()
param_2 = obj.flip()
param_3 = obj.flip()
param_4 = obj.flip()
param_5 = obj.flip()
param_6 = obj.flip()
obj.reset()
