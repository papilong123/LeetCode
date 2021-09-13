class Solution:
    # 状压dp & 回文预处理 & 枚举子集
    def maxProduct(self, s: str) -> int:
        n = len(s)
        res = 0
        d = [False] * (1 << n)  # 记录每个二进制状态是否为回文

        # 预处理每个状态是否为回文
        for i in range(1 << n):
            a = ''
            for j in range(n):
                if i & (1 << j):
                    a += s[j]
            if a[::-1] == a:
                d[i] = True

        # 枚举子集的子集
        for i in range(1 << n):
            j = i
            while j:  # 枚举j的子集
                j = (j - 1) & i
                k = i ^ j  # 求j相对于i的补集
                if d[k] and d[j]:  # 如果两个互为补集的集合都为回文
                    a = bin(k).count('1')
                    b = bin(j).count('1')
                    res = max(res, a * b)  # 取符合条件的最大回文长度乘积
        return res


s = "leetcodecom"
res = Solution().maxProduct(s)
print(res)
