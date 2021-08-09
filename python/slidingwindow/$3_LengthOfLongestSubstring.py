class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import defaultdict
        lookup = defaultdict(int)
        left = 0
        right = 0
        max_len = 0
        cnt = 0
        while right < len(s):
            if lookup[s[right]] > 0:
                cnt += 1
            lookup[s[right]] += 1
            right += 1
            while cnt > 0:
                if lookup[s[left]] > 1:
                    cnt -= 1
                lookup[s[left]] -= 1
                left += 1
            max_len = max(max_len, right - left)
        return max_len


print(Solution().lengthOfLongestSubstring("abcabcbb"))
