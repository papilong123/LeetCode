from collections import Counter


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        # 结果栈
        stk = []
        # counter表示剩余元素的个数
        remainCounter = Counter(s)
        for i in s:
            # 去除重复情况
            if i not in stk:  # 忽略已经在栈内的元素，因为选了一定会比大于等于之前的字典序
                while stk and i < stk[-1] and remainCounter[stk[-1]] > 0:  # 比栈顶元素小并且i后面还有剩余的栈顶元素
                    stk.pop()
                stk.append(i)
            remainCounter[i] -= 1  # 已经处理掉一个s中的i，i的词频减一
        return ''.join(stk)


solution = Solution()
solution.removeDuplicateLetters("cbacdcbc")
