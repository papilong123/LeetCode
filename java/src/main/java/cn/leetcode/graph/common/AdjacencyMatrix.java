package cn.leetcode.graph.common;

public class AdjacencyMatrix {
    int N = 10;
    // 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
    public int[][] w = new int[N][N];

    // 加边操作
    public void add(int a, int b, int c) {
        w[a][b] = c;
    }
}
