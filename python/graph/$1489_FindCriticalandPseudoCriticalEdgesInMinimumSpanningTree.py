from typing import List

from union_find.UnionFind import UnionFind


# 找到最小生成树里的关键边和伪关键边
# Kruskal 算法
class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        m = len(edges)
        for i, edge in enumerate(edges):  # 给每条边编号
            edge.append(i)
        edges.sort(key=lambda x: x[2])  # 根据权值从小到大排序

        # 计算 value(最小生成树的权值之和)
        uf_std = UnionFind(n)
        uf_std.parent = list(range(n))
        value = 0
        for i in range(m):
            if uf_std.unite(edges[i][0], edges[i][1]):
                value += edges[i][2]  # 得到最小生成树权值和

        ans = [[], []]

        for i in range(m):  # 尝试每条边
            # 判断是否是关键边
            uf = UnionFind(n)
            uf.parent = list(range(n))
            v = 0
            for j in range(m):  # 要么整个图不连通，不存在最小生成树
                if i != j and uf.unite(edges[j][0], edges[j][1]):
                    v += edges[j][2]
            if uf.setCount != 1 or (uf.setCount == 1 and v > value):  # 要么整个图连通，对应的最小生成树的权值为v，其严格大于value。
                ans[0].append(edges[i][3])
                continue

            # 判断是否是伪关键边
            # 可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边
            uf = UnionFind(n)
            uf.parent = list(range(n))  # 初始化每个节点指向自己代表的子集
            uf.unite(edges[i][0], edges[i][1])
            v = edges[i][2]
            for j in range(m):  # 在计算最小生成树的过程中，最先考虑这条边，即最先将这条边的两个端点在并查集中合并。设最终得到的最小生成树权值为v，如果v=value，那么这条边就是伪关键边。
                if i != j and uf.unite(edges[j][0], edges[j][1]):
                    v += edges[j][2]
            if v == value:
                ans[1].append(edges[i][3])

        return ans


n = 5
edges = [[0, 1, 1], [1, 2, 1], [2, 3, 2], [0, 3, 2], [0, 4, 3], [3, 4, 3], [1, 4, 6]]
res = Solution().findCriticalAndPseudoCriticalEdges(n, edges)
print(res)
