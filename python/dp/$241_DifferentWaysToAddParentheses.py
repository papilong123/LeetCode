from functools import lru_cache
from typing import List


class Solution:
    @lru_cache
    def diffWaysToCompute(self, input: str) -> List[int]:
        if input.isdigit():
            return [int(input)]
        res = []
        left, right = [], []
        for i, char in enumerate(input):
            if char in ['+', '-', '*']:
                left = self.diffWaysToCompute(input[:i])
                right = self.diffWaysToCompute(input[i + 1:])
            for l in left:
                for r in right:
                    if char == '+':
                        res.append(l + r)
                    elif char == '-':
                        res.append(l - r)
                    elif char == '*':
                        res.append(l * r)
        return res


res = Solution().diffWaysToCompute("2*3-4*5")
print(res)
