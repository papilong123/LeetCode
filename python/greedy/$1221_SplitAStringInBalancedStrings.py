class Solution:
    def balancedStringSplit(self, s: str) -> int:
        _sum = 0
        cnt = 0
        for i in range(len(s)):
            if s[i] == 'R':
                _sum += 1
            elif s[i] == 'L':
                _sum -= 1
            if _sum == 0:
                cnt += 1
        return cnt
