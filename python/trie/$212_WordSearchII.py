from typing import List

from trie.Trie import Trie


class Solution:
    # 回溯 + 字典树
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.insert(word)

        def dfs(now, x, y, path):
            ch = board[x][y]
            idx = ord(ch) - ord('a')
            # 当前路径不是 words 中任意一个单词的前缀（没有到None），则剪枝
            if ch == '#' or not now.children[idx]:
                return

            # 如果当前路径是 words 中的单词，则将其添加到结果集中
            path += chr(idx + ord('a'))
            now = now.children[idx]
            if now.isEnd:  # 判断是否走到一个单词的最后一个字母，走到了就加入结果
                ans.add(path)

            # 当前路径是 words 中任意一个单词的前缀，则继续搜索
            # 回溯标记为'#'
            board[x][y] = "#"
            for nx, ny in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)):
                if 0 <= nx < m and 0 <= ny < n:
                    dfs(now, nx, ny, path)  # 字典树和二维坐标同时移动
            board[x][y] = ch

        ans = set()  # 答案可能会重复
        m, n = len(board), len(board[0])

        for i in range(m):
            for j in range(n):
                p = ""
                dfs(trie, i, j, p)

        return list(ans)


_board = [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]]
_words = ["oath", "pea", "eat", "rain"]
_board1 = [["a"]]
_words1 = ["a"]

r = Solution().findWords(_board1, _words1)
print(r)
