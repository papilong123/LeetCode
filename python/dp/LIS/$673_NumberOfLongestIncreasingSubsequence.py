from collections import Callable
from typing import List


# 贪心 + 前缀和 + 二分查找
class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        d, cnt = [], []  # d[i] 数组表示所有能成为长度为 i 的最长上升子序列的末尾元素的值
        for v in nums:
            i = bisect(len(d), lambda i: d[i][-1] >= v)
            c = 1
            if i > 0:
                k = bisect(len(d[i - 1]), lambda k: d[i - 1][k] < v)
                c = cnt[i - 1][-1] - cnt[i - 1][k]
            
            if i == len(d):  # 比所有元素都大
                d.append([v])  # d添加一个包含当前值的新数组
                cnt.append([0, c])  # cnt[i][j] 记录了以 d[i][j] 为结尾的最长上升子序列的个数
            else:
                d[i].append(v)  # 比所有元素都小
                cnt[i].append(cnt[i][-1] + c)
        return cnt[-1][-1]

    def findNumberOfLISRaw(self, nums: List[int]) -> int:
        n, max_len, ans = len(nums), 0, 0
        dp = [0] * n
        cnt = [0] * n
        for i, x in enumerate(nums):
            dp[i] = 1
            cnt[i] = 1  # cnt[i] 表示以 nums[i] 结尾的最长上升子序列的个数
            for j in range(i):
                if x > nums[j]:
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        cnt[i] = cnt[j]  # 重置计数
                    elif dp[j] + 1 == dp[i]:
                        cnt[i] += cnt[j]
            if dp[i] > max_len:
                max_len = dp[i]
                ans = cnt[i]  # 重置计数
            elif dp[i] == max_len:
                ans += cnt[i]
        return ans


# 左查找
def bisect(n: int, f: Callable[[int], bool]) -> int:
    l, r = 0, n
    while l < r:
        mid = (l + r) // 2
        if f(mid):
            r = mid
        else:
            l = mid + 1
    return l


if __name__ == '__main__':
    obj = Solution()
    r = obj.findNumberOfLIS([1, 3, 5, 4, 7])
    print(r)
