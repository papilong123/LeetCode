from typing import List


class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        arr = [int(i) for i in nums]
        arr.sort(key=lambda o: -o)
        s = set(arr)
        li = []
        for j in s:
            li.append(j)
        li.sort(key=lambda o: -o)
        return str(li[li.index(arr[k - 1])])


res = Solution().kthLargestNumber(["0", "0"], 2)
print(res)
