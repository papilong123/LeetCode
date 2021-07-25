from collections import Counter


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        # 结果栈
        res = []
        # counter表示剩余元素的个数
        remainCounter = Counter(s)
        for i in s:
            # 去除重复情况
            if i not in res:
                while res and i < res[-1] and remainCounter[res[-1]] > 0:
                    res.pop()
                res.append(i)
            remainCounter[i] -= 1
        return ''.join(res)


solution = Solution()
solution.removeDuplicateLetters("cbacdcbc")
