class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def get_cnt(prefix, n):
            cnt, cur, next = 0, prefix, prefix + 1
            while cur <= n:
                cnt += min(next, n + 1) - cur
                cur *= 10
                next *= 10
            return cnt

        p, prefix = 1, 1
        while p < k:
            num = get_cnt(prefix, n)
            if p + num > k:  # 在当前子节点下
                prefix *= 10
                p += 1
            else:
                prefix += 1
                p += num
        return prefix


Solution().findKthNumber(100, 10)
