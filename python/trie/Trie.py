from collections import defaultdict


# https://blog.csdn.net/weixin_43314519/article/details/106990273
# 数组实现
class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

    def insert(self, word: str) -> None:
        node = self
        for ch in word:
            ch = ord(ch) - ord("a")
            if not node.children[ch]:
                node.children[ch] = Trie()
            node = node.children[ch]
        node.isEnd = True

    def searchPrefix(self, prefix: str) -> "Trie":
        node = self
        for ch in prefix:
            ch = ord(ch) - ord("a")
            if not node.children[ch]:
                return None
            node = node.children[ch]
        return node

    def search(self, word: str) -> bool:
        node = self.searchPrefix(word)
        return node is not None and node.isEnd

    def startsWith(self, prefix: str) -> bool:
        return self.searchPrefix(prefix) is not None


# defaultdict实现版
class TrieMini:
    def __init__(self):
        self.children = defaultdict(TrieMini)
        self.word = ""
        self.isEnd = False

    def insert(self, word):
        node = self
        for ch in word:
            node = node.children[ch]
        node.isEnd = True
        node.word = word

    def searchPrefix(self, prefix: str) -> "TrieMini":
        node = self
        for ch in prefix:
            if not node.children.get(ch, None):
                return None
            node = node.children[ch]
        return node

    def search(self, word):
        node = self.searchPrefix(word)
        return node is not None and node.isEnd

    def startsWith(self, prefix: str) -> bool:
        return self.searchPrefix(prefix) is not None
