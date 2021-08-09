# 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t。
class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import defaultdict
        lookup = defaultdict(int)
        left, right = 0, 0
        max_len = 0
        cnt = 0
        while right < len(s):
            if lookup[s[right]] == 0:  # 新出现的元素
                cnt += 1
            lookup[s[right]] += 1
            right += 1
            while cnt > 2:  # 超过两个元素时循环
                if lookup[s[left]] == 1:  # 刚好某一种元素数量为一，要删除之时
                    cnt -= 1
                lookup[s[left]] -= 1
                left += 1
            max_len = max(max_len, right - left)
        return max_len


ans = Solution().lengthOfLongestSubstringTwoDistinct('eczema')
