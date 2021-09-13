import copy
import heapq
from collections import defaultdict
from typing import List


class Solution:
    def smallestMissingValueSubtree(self, parents: List[int], nums: List[int]) -> List[int]:
        n = len(nums)
        son = defaultdict(list)
        for i, p in enumerate(parents):  # 建立孩子列表，字典键是父节点，前序遍历
            son[p].append(i)
        # 求解一棵子树中缺失的最小基因值，就是在求解除这棵子树外树上其他所有节点的最小值
        # print(son)

        # minn[node]表示以node为根的子树内的最小值（包括node）
        minn = copy.copy(nums)

        def dfs(node):  # 深搜
            if node not in son:
                return minn[node]  # 叶子节点直接返回自己的基因值
            for i in son[node]:
                minn[node] = min(minn[node], dfs(i))  # 从自己的基因值和子节点的返回的最小值之间选择最小的基因值存到自己的位置上
            return minn[node]

        dfs(0)

        # ans[node]表示 除以node为根的子树外，树上所有节点的最小值（不包括node）
        ans = [0] * n
        p = 1
        numm = sorted(nums)
        while n >= p == numm[p - 1]:  # 在树中且下标与值对应
            p += 1
        ans[0] = p  # 找到父节点对应的基因值

        # print(minn)

        def dfs2(node):
            # print(node, ans[node])
            if node not in son:
                return  # 叶子节点直接返回

            # 建立两个元素的小顶堆
            q = [min(nums[node], ans[node]), max(nums[node], ans[node])]

            for i in son[node]:
                heapq.heappush(q, minn[i])  # 当前节点子节点的子树的最小值节点加入小顶堆
            # print(q)
            for i in son[node]:
                if q[0] == minn[i]:
                    tmp = heapq.heappop(q)
                    ans[i] = q[0]  # 相等则记录第二小元素然后深搜
                    dfs2(i)
                    heapq.heappush(q, tmp)
                else:  # 不相等则直接记录答案然后深搜
                    ans[i] = q[0]
                    dfs2(i)
            return

        dfs2(0)

        return ans


class Solution2:
    def smallestMissingValueSubtree(self, parents: List[int], nums: List[int]) -> List[int]:
        n = len(parents)
        res = [1] * n  # 只有值1的祖先和它本身有缺失值>1。那就是从根0到节点值为1的路径，所以我们要处理这条路径上的节点
        seen = [0] * 100010
        if 1 not in nums:  # 没有1的基因值，返回全1
            return res

        # 前序遍历建图
        children = defaultdict(list)
        for i in range(1, n):
            children[parents[i]].append(i)

        def dfs(i):
            if seen[nums[i]] == 0:  # 基因值没搜过
                for j in children[i]:
                    dfs(j)
                seen[nums[i]] = 1

        i = nums.index(1)  # 父节点的位置
        miss = 1
        while i >= 0:  # 从下向上，一直到树根
            dfs(i)
            while seen[miss]:
                miss += 1

            res[i] = miss
            i = parents[i]
        return res


out_parents = [-1, 0, 1, 0, 3, 3]  # 前序遍历的父列表
out_nums = [5, 4, 6, 2, 1, 3]  # 前序遍历的基因列表
r = Solution2().smallestMissingValueSubtree(out_parents, out_nums)
print(r)
