from typing import List


class Solution:
    # 初始化两个指针 i 和 j，分别指向 t 和 s 的初始位置。
    # 每次贪心地匹配，匹配成功则 i 和 j 同时右移，匹配 t 的下一个位置，匹配失败则 j 右移，i 不变，尝试用 s 的下一个字符匹配 t
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        res = ""
        for t in dictionary:
            i = j = 0
            while i < len(t) and j < len(s):
                if t[i] == s[j]:
                    i += 1
                j += 1
            # 最终如果 i 移动到 t 的末尾，则说明 t 是 s 的子序列。
            # 遍历 dictionary 中的字符串，并维护当前长度最长且字典序最小的字符串来找到
            if i == len(t) and (len(t) > len(res) or (len(t) == len(res) and t < res)):
                res = t
        return res


s = "abpcplea"
dictionary = ["ale", "applf", "apple", "monkey", "plea"]
r = Solution().findLongestWord(s, dictionary)
