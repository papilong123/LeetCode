package cn.leetcode.graph.common;

// 于边数较多的「稠密图」使用，当边数量接近点的数量的平方，可定义为「稠密图」。
// 这也是一种在图论中十分常见的存图方式，与数组存储单链表的实现一致（头插法）。
// 这种存图方式又叫「链式前向星存图」。
// 适用于边数较少的「稀疏图」使用，当边数量接近点的数量，即  时，可定义为「稀疏图」。

// 首先 idx 是用来对边进行编号的，然后对存图用到的几个数组作简单解释：
//
// he 数组：存储是某个节点所对应的边的集合（链表）的头结点；
// e  数组：由于访问某一条边指向的节点；
// ne 数组：由于是以链表的形式进行存边，该数组就是用于找到下一条边；
// w  数组：用于记录某条边的权重为多少。
public class AdjacencyList {
    int N = 10;
    int M = 10;

    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    int idx;

    public void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }
}

// 因此当我们想要遍历所有由 a 点发出的边时，可以使用如下方式
// for (int i = he[a]; i != -1; i = ne[i]) {
//    int b = e[i], c = w[i]; // 存在由 a 指向 b 的边，权重为 c
// }
