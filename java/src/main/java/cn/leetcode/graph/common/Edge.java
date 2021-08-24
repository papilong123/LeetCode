package cn.leetcode.graph.common;

public class Edge {
    // 代表从 a 到 b 有一条权重为 c 的边
    int a, b, c;

    Edge(int _a, int _b, int _c) {
        a = _a;
        b = _b;
        c = _c;
    }
}
// 通常我们会使用 List 存起所有的边对象，并在需要遍历所有边的时候，进行遍历
// List<Edge> es = new ArrayList<>();
//     ...
// for (Edge e : es) {
//     ...
// }
