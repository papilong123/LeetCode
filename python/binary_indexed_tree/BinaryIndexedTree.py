# https://blog.csdn.net/bestsort/article/details/80796531
# 查询和修改复杂度都为log(n), 主要用于数组的单点修改&&区间求和, 是线段树的简化版
class BinaryIndexedTree:
    def __init__(self, n):
        self.arr = [0] * (n + 1)  # 长度为n+1
        self.n = n

    def lowbit(self, x: int) -> int:  # 获取最低位的1
        return x & -x

    def update(self, index: int, val: int) -> None:  # 单点修改
        while index <= self.n:
            self.arr[index] += val
            index += self.lowbit(index)

    def query(self, index: int) -> int:  # 区间求和
        ans = 0
        while index > 0:
            ans += self.arr[index]
            index -= self.lowbit(index)
        return ans
