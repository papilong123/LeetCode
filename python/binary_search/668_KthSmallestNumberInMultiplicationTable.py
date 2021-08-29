class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        def helper(mid, m, n):
            count = 0
            for i in range(1, m + 1):
                count += min(mid // i, n)  # 计算每一行小于mid数的个数
            return count

        low, high = 1, m * n + 1
        while low < high:
            mid = (low + high) // 2
            count = helper(mid, m, n)
            if count >= k:
                high = mid
            else:
                low = mid + 1
        return low


Solution().findKthNumber(10, 12, 28)
