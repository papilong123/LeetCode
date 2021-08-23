class Solution:
    def minTimeToType(self, word: str) -> int:
        last = 'a'
        res = 0
        for i in range(len(word)):
            minn = min(abs(ord(word[i]) - ord(last)), 26 - abs(ord(word[i]) - ord(last)))
            res += minn + 1
            last = word[i]
        return res


res = Solution().minTimeToType("abc")
