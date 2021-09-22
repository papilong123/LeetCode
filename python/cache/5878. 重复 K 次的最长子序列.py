from collections import Counter
from itertools import permutations


class Solution:
    # 词频+全排列
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        c = Counter(s)
        hot = ''.join(ele * (c[ele] // k) for ele in sorted(c, reverse=True))
        for i in range(len(hot), 0, -1):
            for item in permutations(hot, i):  # 所有子数组的全排列
                word = ''.join(item)
                it = iter(s)
                if all(c in it for c in word * k):
                    return word
        return ''


_s = "letsleetcode"
_k = 2
obj = Solution().longestSubsequenceRepeatedK(_s, _k)
