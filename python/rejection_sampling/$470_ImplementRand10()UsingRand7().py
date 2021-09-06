# The rand7() API is already defined for you.
# def rand7():
# @return a random integer in the range 1 to 7
import random


def rand7():
    return random.randint(1, 7)


# 时间复杂度：期望时间复杂度为 O(1)，但最坏情况下会达到 O(∞)（一直被拒绝）。
# 空间复杂度：O(1)。
class Solution:
    def rand10(self):  # 拒绝采样中，如果生成的随机数满足要求，那么就返回该随机数，否则会不断生成，直到生成一个满足要求的随机数为止
        """
        :rtype: int
        """
        while True:
            row = rand7()
            col = rand7()
            idx = (row - 1) * 7 + col
            if idx <= 40:  # 取前40个概率相等的下标
                return 1 + (idx - 1) % 10

    def rand10_optimism(self) -> int:  # 计算被拒绝的概率
        while True:
            a = rand7()
            b = rand7()
            idx = (a - 1) * 7 + b
            if idx <= 40:
                return 1 + (idx - 1) % 10
            a = idx - 40
            b = rand7()
            # get uniform dist from 1 - 63
            idx = (a - 1) * 7 + b
            if idx <= 60:
                return 1 + (idx - 1) % 10
            a = idx - 60
            b = rand7()
            # get uniform dist from 1 - 21
            idx = (a - 1) * 7 + b
            if idx <= 20:
                return 1 + (idx - 1) % 10
