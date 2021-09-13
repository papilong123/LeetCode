class Solution:
    # 贪心，左一遍，右一遍
    def checkValidString(self, s: str) -> bool:
        minCount = 0
        maxCount = 0
        n = len(s)
        for i in range(n):
            c = s[i]
            if c == '(':
                minCount += 1
                maxCount += 1
            elif c == ')':
                minCount = max(minCount - 1, 0)  # 最小可能值不能小于0
                maxCount -= 1
                if maxCount < 0:  # 任何情况下，未匹配的左括号数量必须非负，因此当最大值变成负数时，说明没有左括号可以和右括号匹配，返回 False
                    return False
            else:
                minCount = max(minCount - 1, 0)
                maxCount += 1

        return minCount == 0


res = Solution().checkValidString('(')
print(res)
