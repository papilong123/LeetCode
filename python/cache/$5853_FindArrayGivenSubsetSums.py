from typing import List

from sortedcontainers import SortedList


class Solution:
    def recoverArray(self, n: int, sums: List[int]) -> List[int]:
        BIAS = -min(sums)

        st = SortedList()
        for x in sums:
            st.add(x + BIAS)  # 全部变成非负整数，且排序
        st.discard(st[0])  # 删除最小的元素，也就是答案之一
        ans = [st[0]]

        for i in range(1, n):  # 得到n-1个剩下的结果
            for msk in range(1 << i):  # 找出所有子集和
                if (msk >> (i - 1)) & 1:  # 避免重复删除(保证ans最新的一位被取到)，即第i位为1

                    # 得到全部排列的和
                    sm = 0
                    for j in range(i):
                        if (msk >> j) & 1:
                            sm += ans[j]

                    # 删除当前排列和
                    st.discard(sm)
            ans.append(st[0])  # 得到的全都是答案的绝对值

        for i in range(1 << n):  # 找出一个和为BIAS的子集
            sm = 0
            for j in range(n):
                if (i >> j) & 1:
                    sm += ans[j]
            if sm == BIAS:
                for j in range(n):
                    if (i >> j) & 1:
                        ans[j] = -ans[j]
                break
        return ans


Solution().recoverArray(4, [0, 0, 5, 5, 4, -1, 4, 9, 9, -1, 4, 3, 4, 8, 3, 8])
