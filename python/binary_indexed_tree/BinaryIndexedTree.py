# https://blog.csdn.net/bestsort/article/details/80796531
class BinaryIndexedTree:
    def __init__(self, n):
        self.arr = [0] * (n + 1)
        self.n = n

    def lowbit(self, x: int) -> int:
        return x & -x

    def update(self, index: int, val: int) -> None:
        while index <= self.n:
            self.arr[index] += val
            index += self.lowbit(index)

    def query(self, index: int) -> int:
        ans = 0
        while index > 0:
            ans += self.arr[index]
            index -= self.lowbit(index)
        return ans
