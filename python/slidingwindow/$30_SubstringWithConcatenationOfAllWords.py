from typing import List


class Solution:
    # 多起点字符串级滑动窗口
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        from collections import Counter
        one_word = len(words[0])
        count_words = len(words)
        n = len(s)
        words = Counter(words)
        ans = []
        for i in range(0, one_word):
            counter = Counter()
            left = right = i
            cnt = 0  # cnt代表窗口长度，也是单词总个数
            while right + one_word <= n:
                right_w = s[right: right + one_word]
                cnt += 1
                counter[right_w] += 1
                right += one_word
                while counter[right_w] > words[right_w]:  # 当单个单词重复的数量多于限定的数量时
                    left_w = s[left: left + one_word]
                    cnt -= 1
                    counter[left_w] -= 1
                    left += one_word
                if cnt == count_words:  # 没有超出每个单词规定数量，并且窗口长度等于列表长度
                    ans.append(left)
        return ans
