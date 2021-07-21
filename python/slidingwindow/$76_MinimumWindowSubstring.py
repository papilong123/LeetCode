class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import defaultdict
        hashmap = defaultdict(int)
        for i in t:
            hashmap[i] += 1
        start = 0
        end = 0
        min_len = float('inf')  # python中无穷大的表示
        counter = len(t)
        res = ""
        while end < len(s):
            if hashmap[s[end]] > 0:
                counter -= 1
            hashmap[s[end]] -= 1  # 这里用的是减，counter代表还未匹配到的t中字符串的数量
            end += 1
            while counter == 0:  # 满足条件时循环
                if end - start < min_len:  # 记录位置
                    min_len = end - start
                    res = s[start: end]
                if hashmap[s[start]] == 0:  # 此处只有等于零的才是t中元素，别的元素都小于零
                    counter += 1
                hashmap[s[start]] += 1
                start += 1
        return res


ans = Solution().minWindow("ADOBECODEBANC", "ABC")
