from collections import Counter
from typing import List


class Solution:
    def minimumSwitchingTimes(self, source: List[List[int]], target: List[List[int]]) -> int:
        counter1 = Counter()
        counter2 = Counter()
        for i in range(len(source)):
            for j in range(len(source[0])):
                counter1[source[i][j]] += 1
        for i in range(len(target)):
            for j in range(len(target[0])):
                counter2[target[i][j]] += 1
        ans = 0
        for i in counter1:
            ans += max(0, counter1[i] - counter2[i])
        return ans


res = Solution().minimumSwitchingTimes([[7]], [[1]])
print(res)
