import math


class StockSpanner:

    def __init__(self):
        # 单减栈
        self.stk = [(math.inf, -1)]
        self.i = -1

    def next(self, price: int) -> int:
        self.i += 1
        while self.stk and self.stk[-1][0] <= price:
            self.stk.pop()
        width = self.i - self.stk[-1][1]
        self.stk.append((price, self.i))
        return width


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)


instance = StockSpanner()
res1 = instance.next(100)
res2 = instance.next(80)
res3 = instance.next(60)
res4 = instance.next(70)
res5 = instance.next(60)
res6 = instance.next(75)
res7 = instance.next(85)
