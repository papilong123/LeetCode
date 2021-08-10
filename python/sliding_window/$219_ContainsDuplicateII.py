from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        """
        :param nums:
        :param k:
        """
        s = set()
        for i in range(len(nums)):
            if s.__contains__(nums[i]):
                return True
            s.add(nums[i])
            if len(s) > k:
                s.remove(nums[i-k])
        return False
