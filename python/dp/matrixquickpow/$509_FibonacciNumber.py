import numpy as np


# 时间复杂度可以达到log(n)
class Solution:
    def fib(self, n: int) -> int:
        A = np.array([[0, 1], [1, 1]])
        B = np.eye(2, dtype=np.int64)
        mod = int(1e9 + 7)
        while n > 0:
            if n & 1:
                B = np.mod(np.dot(B, A), mod)
            A = np.mod(np.dot(A, A), mod)
            n >>= 1
        x = np.array([0, 1])
        y = np.mod(np.dot(B, x), mod)
        return int(y[0])


res = Solution().fib(7)
print(res)
