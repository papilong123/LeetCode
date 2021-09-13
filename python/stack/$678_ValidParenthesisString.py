class Solution:
    def checkValidString(self, s):
        stack_left, stack_star = [], []
        for i in range(len(s)):
            # 左括号//星号 都分别入栈
            if s[i] == '(':
                stack_left.append(i)
            elif s[i] == '*':
                stack_star.append(i)
            # 如果遇到右括号
            elif s[i] == ')':
                # 如果有尚未匹配左括号 先与栈顶的左括号匹配
                if stack_left:
                    stack_left.pop()
                # 如果有尚未消耗的星号 则变身左括号与s[i]匹配 (出栈)
                elif stack_star:
                    stack_star.pop()
                else:
                    return False
        # stack_left非空 也可能有效 只要满足for any左括号, there exist a 右侧的'*'(index更大)
        # 因为越靠近栈顶index越大 只需判断栈顶'*' 当栈顶的'*'的ind大于当前左括号ind的时候弹出
        while stack_left:
            if not stack_star:
                return False  # 无*匹配
            elif stack_left[-1] > stack_star[-1]:
                return False  # 无右侧*匹配
            else:
                stack_left.pop()
                stack_star.pop()
        return True
