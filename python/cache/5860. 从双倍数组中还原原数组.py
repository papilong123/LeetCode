from collections import defaultdict
from typing import List


class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        n = len(changed)
        if n % 2 == 1:
            return []

        changed.sort()

        dd = defaultdict(int)
        for x in changed:
            dd[x] += 1
        res = []
        for num in changed:
            if dd[num] > 0:
                if dd[num] > dd[2 * num]:
                    return []
                res.append(num)
                dd[num] -= 1
                dd[num * 2] -= 1
        return res


arr = [6, 3, 0, 1]
r = Solution().findOriginalArray([6, 3, 0, 1])
print(r)
