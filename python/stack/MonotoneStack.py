from typing import List


class MonotoneStack:
    def canSeePersonsCount(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        arr = [0] * n
        for i in range(n - 1, -1, -1):
            cnt = 0
            while stack and nums[stack[-1]] < nums[i]:
                stack.pop()
                cnt += 1
            arr[i] = cnt + 1 if stack else cnt  # 如果非空，他还能看见一个人（即最后一个把别人遮住的人）
            stack.append(i)
        return arr
