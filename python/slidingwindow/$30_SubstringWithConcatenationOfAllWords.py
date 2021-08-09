from typing import List


class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        from collections import Counter
        one_word = len(words[0])
        list_len = len(words)
        n = len(s)
        words = Counter(words)
        ans = []
        for i in range(0, one_word):
            left = i
            right = i
            cnt = 0
            counter = Counter()
            while right + one_word <= n:
                right_w = s[right: right + one_word]
                right += one_word
                cnt += 1
                counter[right_w] += 1
                while counter[right_w] > words[right_w]:
                    left_w = s[left: left + one_word]
                    left += one_word
                    cnt -= 1
                    counter[left_w] -= 1
                if cnt == list_len:
                    ans.append(left)
        return ans
