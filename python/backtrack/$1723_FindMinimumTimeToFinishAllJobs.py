from typing import List


class Solution:
    def minimumTimeRequired(self, jobs: List[int], k: int) -> int:
        jobs.sort(reverse=True)  # 排序后利于剪枝
        left, right = jobs[0], sum(jobs)

        def check(jobs, limit):
            workload = [0] * k
            return dfs(jobs, workload, 0, limit)

        def dfs(jobs, workload, i, limit):
            if i >= len(jobs):
                return True

            cur = jobs[i]
            for j in range(k):
                if workload[j] + cur <= limit:
                    workload[j] += cur
                    if dfs(jobs, workload, i + 1, limit):
                        return True
                    workload[j] -= cur

                    if workload[j] == 0 or workload[j] + cur == limit:
                        break
            return False

        while left < right:
            mid = left + ((right - left) >> 1)
            if check(jobs, mid):
                right = mid
            else:
                left = mid + 1
        return left


jobs = [12, 13, 14, 17, 25]
k = 3
res = Solution().minimumTimeRequired(jobs, k)
print()
