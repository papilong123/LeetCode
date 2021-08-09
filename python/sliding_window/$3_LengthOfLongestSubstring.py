class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import Counter
        counter = Counter()
        left, right = 0, 0
        max_len = 0  # 最大长度
        cnt = 0  # cnt代表多出来重复的个数
        while right < len(s):
            if counter[s[right]] > 0:
                cnt += 1
            counter[s[right]] += 1
            right += 1
            while cnt > 0:
                if counter[s[left]] > 1:
                    cnt -= 1
                counter[s[left]] -= 1
                left += 1
            max_len = max(max_len, right - left)
        return max_len


print(Solution().lengthOfLongestSubstring("abcabcbb"))
