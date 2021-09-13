import bisect
import itertools
from typing import List


class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        n = len(chalk)
        acc = list(itertools.accumulate(chalk))
        target = int(k % acc[-1])
        idx = bisect.bisect_left(acc, target)
        return idx + 1 if acc[idx] == target else idx
