class AdjacencyMatrix:
    N = 10

    def __init__(self):
        self.N = 10

    # 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
    w = [[0] * N for _ in range(N)]

    # 加边操作
    def add(self, a: int, b: int, c: int):
        self.w[a][b] = c
