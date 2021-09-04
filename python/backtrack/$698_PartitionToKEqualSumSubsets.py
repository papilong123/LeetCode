class Solution:
    def canPartitionKSubsets(self, nums, k):
        n = len(nums)
        tsum = sum(nums)

        if tsum % k != 0:
            return False
        target = tsum / k
        # 排序剪枝
        nums.sort(reverse=True)
        if nums[0] > target:
            return False

        used = [False] * n  # 把数组分为两部分：已经满足target的group元素和待处理的剩下元素

        def dfs(cur, begin, k):
            if k == 0:
                return True
            if cur > target:
                return False
            if cur == target:
                return dfs(0, 0, k - 1)  # 剩下的元素是否能被等和分割成k-1份
            for i in range(begin, n):
                if not used[i]:
                    used[i] = True
                    if dfs(cur + nums[i], i + 1, k):  # 加上当前元素后能否被等和分割成k份
                        return True
                    used[i] = False  # 可以帮助下一组（k-1）与这一组的元素区分开来
            return False

        return dfs(0, 0, k)
