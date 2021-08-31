class Solution:
    def calculate(self, s: str) -> int:
        d = {'+': 1, '-': 1, '*': 2, '/': 2, '%': 2, '^': 3}
        ops = []
        nums = [0]
        i, n = 0, len(s)

        def calc(nums, ops):
            if not ops or len(nums) < 2 or not ops:
                return
            b, a = nums.pop(), nums.pop()
            op = ops.pop()
            ans = 0
            if op == '+':
                ans = a + b
            elif op == '-':
                ans = a - b
            elif op == '*':
                ans = a * b
            elif op == '/':
                ans = a // b
            elif op == '%':
                ans = a % b
            elif op == '^':
                ans = pow(a, b)
            nums.append(ans)

        while i < n:
            if s[i] == ' ':
                i += 1
                continue
            elif s[i] == '(':
                ops.append(s[i])
            elif s[i] == ')':
                while ops:
                    if ops[-1] != '(':
                        calc(nums, ops)
                    else:
                        ops.pop()
                        break
            else:
                if s[i].isdigit():
                    j = i
                    val = 0
                    while j < n and s[j].isdigit():
                        val = val * 10 + int(s[j])
                        j += 1
                    nums.append(val)
                    i = j - 1
                else:
                    if i > 0 and s[i - 1] in '(+-':
                        nums.append(0)
                    while ops and ops[-1] != '(':
                        if d[ops[-1]] >= d[s[i]]:
                            calc(nums, ops)
                        else:
                            break
                    ops.append(s[i])
            i += 1
        while ops and ops[-1] != '(':
            calc(nums, ops)
        return nums[-1]


res = Solution().calculate("(0-3)/4")
print(res)
