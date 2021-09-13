class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        n = len(num)
        if n == 0:
            return True
        d = {'0': '0', '1': '1', '6': '9', '8': '8', '9': '6'}
        t = ''
        for i in range(n):
            if num[i] not in d.keys():
                return False
            t += d[num[i]]
        return t[::-1] == num


res = Solution().isStrobogrammatic('69')
