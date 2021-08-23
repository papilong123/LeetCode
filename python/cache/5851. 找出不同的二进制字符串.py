from typing import List


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        s = set(nums)
        n = len(nums)
        for i in range(1 << n):
            t = bin(i)
            tmp = '0' * (n - len(t[2:])) + str(t[2:])
            if tmp not in s:
                return tmp
        return ""


res = Solution().findDifferentBinaryString(["111", "011", "001"])
print(res)
