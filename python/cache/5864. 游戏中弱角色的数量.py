from typing import List


class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        properties.sort(key=lambda o: (o[0], -o[1]))
        cnt = 0
        right = -1
        for x, y in properties[::-1]:
            if right > y:  # 当前值小于右边最大值就加一，因为x位相等，y位降序，所以不会取道与自己x值相等的元素
                cnt += 1
            right = max(right, y)  # 维持一个当前值右边的最大值
        return cnt


ans = Solution().numberOfWeakCharacters([[1, 5], [10, 4], [4, 3], [5, 5], [5, 6], [5, 8], [5, 9], [6, 3], [3, 6]])
print(ans)
