class Solution:
    # 找最长答案
    def slidingwindowlongest(self, s):
        """
        :param s: str
        :rtype: int
        """
        from collections import defaultdict
        counter = defaultdict(int)
        left, right, window_length = 0, 0, 0
        max_len = 0  # 窗口滑动中的最大长度
        cnt = 0
        while right < len(s):
            if counter[s[right]] > 0:  # 重复元素的数量
                cnt += 1
            window_length += 1
            counter[s[right]] += 1
            right += 1
            while cnt > 0:  # 删除重复元素
                if counter[s[left]] > 1:
                    cnt -= 1
                window_length -= 1
                counter[s[left]] -= 1
                left += 1
            max_len = max(max_len, window_length)
        return max_len

    # 找最短答案
    def slidingwindowshortest(self, s):
        """
        :param s: str
        :rtype: int
        """
        from collections import defaultdict
        remain = defaultdict(int)
        left, right, window_length = 0, 0, 0
        max_len = 0  # 窗口滑动中的最大长度
        cnt = 0
        while right < len(s):
            if remain[s[right]] > 0:  # 重复元素的数量
                cnt += 1
            window_length += 1
            remain[s[right]] -= 1
            right += 1
            while cnt > 0:  # 删除重复元素
                if remain[s[left]] > 1:
                    cnt -= 1
                window_length += 1
                remain[s[left]] -= 1
                left += 1
            max_len = max(max_len, window_length)
        return max_len


instance = Solution()
longest = instance.slidingwindowlongest('abcabcbb')
shortest = instance.slidingwindowshortest('abcabcbb')
