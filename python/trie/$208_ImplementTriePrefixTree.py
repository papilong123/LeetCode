from trie.Trie import Trie


class Solution(Trie):
    def __init__(self):
        super().__init__()


if __name__ == '__main__':
    words = [["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    obj = Trie()
    for i in range(len(words)):
        obj.insert(words[i][0])
        param_2 = obj.search(words[i][0])
        param_3 = obj.startsWith(words[i][0])
