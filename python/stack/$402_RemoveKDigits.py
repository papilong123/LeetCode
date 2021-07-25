class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        remain = len(num) - k
        for i, v in enumerate(num):
            while stack and v < stack[-1] and k:
                stack.pop()
                k -= 1
            stack.append(v)
        return "".join(stack[: remain]).lstrip('0') or '0'
