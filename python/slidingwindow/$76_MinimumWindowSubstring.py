class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import Counter
        counter = Counter(t)
        left, right = 0, 0
        min_len = float('inf')  # python中无穷大的表示
        remain = len(t)
        ans = ""
        while right < len(s):
            if counter[s[right]] > 0:  # 只减t中的剩余元素数
                remain -= 1
            counter[s[right]] -= 1  # 这里用的是减，counter代表还未匹配到的t中剩余字符的数量
            right += 1
            while remain == 0:  # 剩余元素为零时循环，此时说明所有元素已经出现一遍
                if right - left < min_len:  # 记录位置
                    min_len = right - left
                    ans = s[left: right]
                if counter[s[left]] == 0:  # 此处只有等于零的才是t中元素，别的元素都小于零
                    remain += 1
                counter[s[left]] += 1
                left += 1
        return ans


v = Solution().minWindow("ADOBECODEBANC", "ABC")
