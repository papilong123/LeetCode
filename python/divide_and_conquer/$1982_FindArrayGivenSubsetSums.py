from typing import List

from sortedcontainers import SortedList


class Solution:
    def recoverArray(self, n: int, sums: List[int]) -> List[int]:
        BIAS = -min(sums)

        st = SortedList()
        for x in sums:
            st.add(x + BIAS)  # 全部变成非负整数，且排序
        st.discard(st[0])  # 删除0，此时st中最小的元素就是ans中的最小值
        ans = [st[0]]

        for i in range(1, n):  # 得到n-1个剩下的结果
            for msk in range(1 << i):  # 搜索所有子集和
                if (msk >> (i - 1)) & 1:  # 避免重复删除(保证ans最新的一位被取到)，即只计算第i-1位为1的子集，既包含第i个元素的子集

                    # 得到包含 ans下标为i-1元素 的子集和
                    sm = 0
                    for j in range(i):
                        if (msk >> j) & 1:
                            sm += ans[j]

                    # 删除当前子集和
                    st.discard(sm)
            ans.append(st[0])  # 添加答案的绝对值到列表

        for i in range(1 << n):  # 找出一个和为BIAS的子集
            sm = 0
            for j in range(n):
                if (i >> j) & 1:
                    sm += ans[j]
            if sm == BIAS:  # 找到子集和为BIAS的子集
                for j in range(n):
                    if (i >> j) & 1:
                        ans[j] = -ans[j]
                break
        return ans


res = Solution().recoverArray(4, [0, 0, 5, 5, 4, -1, 4, 9, 9, -1, 4, 3, 4, 8, 3, 8])
print(res)
