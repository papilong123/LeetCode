# 基于字典的
class Trie:
    def __init__(self):
        self.children = dict()
        self.as_prefix = 0  # 插入word时，每一个w结点+1
        self.as_word = 0  # 插入word结束时，统计一下

    # 插入一个单词word
    def insert(self, word: str) -> None:
        rt = self
        for w in word:
            if w not in rt.children:  # 可以用defaultdict(Trie())省心，但是这种写法思路更清晰
                rt.children[w] = Trie()
            rt.children[w].as_prefix += 1
            rt = rt.children[w]
        rt.as_word += 1

    # 统计word的个数
    def countWordsEqualTo(self, word: str) -> int:
        rt = self
        for w in word:
            if w not in rt.children:
                return 0
            else:
                rt = rt.children[w]
        return rt.as_word

    # 统计前缀prefix的个数
    def countWordsStartingWith(self, prefix: str) -> int:
        rt = self
        for p in prefix:
            if p not in rt.children:
                return 0
            else:
                rt = rt.children[p]
        return rt.as_prefix

    # 只擦除一个word
    def erase(self, word: str) -> None:
        rt = self
        for w in word:
            if w not in rt.children:
                return
            else:
                rt.children[w].as_prefix -= 1
                rt = rt.children[w]
        rt.as_word -= 1


# 基于数组的
class TrieArray:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.as_prefix = 0  # 插入word时，每一个w结点+1
        self.as_word = 0  # 插入word结束时，统计一下

    # 插入一个单词word
    def insert(self, word: str) -> None:
        rt = self
        for w in word:
            ID = ord(w) - ord('a')
            if rt.children[ID] is None:  # 可以用defaultdict(TrieArray())省心，但是这种写法思路更清晰
                rt.children[ID] = TrieArray()
            rt.children[ID].as_prefix += 1
            rt = rt.children[ID]
        rt.as_word += 1

    # 统计word的个数
    def countWordsEqualTo(self, word: str) -> int:
        rt = self
        for w in word:
            ID = ord(w) - ord('a')
            if rt.children[ID] is None:
                return 0
            else:
                rt = rt.children[ID]
        return rt.as_word

    # 统计前缀prefix的个数
    def countWordsStartingWith(self, prefix: str) -> int:
        rt = self
        for p in prefix:
            ID = ord(p) - ord('a')
            if rt.children[ID] is None:
                return 0
            else:
                rt = rt.children[ID]
        return rt.as_prefix

    # 只擦除一个word
    def erase(self, word: str) -> None:
        rt = self
        for w in word:
            ID = ord(w) - ord('a')
            if rt.children[ID] is None:
                return
            else:
                rt.children[ID].as_prefix -= 1
                rt = rt.children[ID]
        rt.as_word -= 1
