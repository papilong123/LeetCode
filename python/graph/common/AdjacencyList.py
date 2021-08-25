class AdjacencyList:
    N = 10
    M = 10

    he = [0] * N
    e = [0] * M
    ne = [0] * M
    w = [0] * M
    idx = 0

    def add(self, a, b, c):
        self.e[self.idx] = b
        self.ne[self.idx] = self.he[a]
        self.he[a] = self.idx
        self.w[self.idx] = c
        self.idx += 1
