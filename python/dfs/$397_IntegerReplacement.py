class Solution:
    def integerReplacement(self, n: int) -> int:
        cnt = 0
        while n != 1:
            if n % 2 == 0:
                n = n // 2
                cnt += 1
            else:
                n += -1 if n & 2 == 0 or n == 3 else 1
                cnt += 1
        return cnt
