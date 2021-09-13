from typing import List

from sortedcontainers import SortedList


# 扫描线算法基本思想&优先队列维护当前最大高度
class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        ans = []

        # 预处理所有的点，为了方便排序，对于左端点，令高度为负；对于右端点令高度为正
        ps = []
        for left, right, h in buildings:  # 以高度正负区分左右端点，这一点妙啊
            ps.append((left, - h))
            ps.append((right, h))
        # 先按照横坐标进行排序
        # 如果横坐标相同，则按照左端点排序
        # 如果相同的左/右端点，则按照高度进行排序
        ps.sort()

        prev = 0  # 前一矩形“上边”延展而来的上一个记录的高度
        pq = SortedList([prev])  # 有序列表充当大根堆

        for point, height in ps:
            if height < 0:  # 如果是左端点，说明存在一条往右延伸的可记录的边，将高度存入优先队列
                pq.add(-height)
            else:  # 如果是右端点，说明这条边结束了，将当前高度从队列中移除
                pq.remove(height)

            cur = pq[-1]  # 取出最高高度，如果当前不与前一矩形“上边”延展而来的那些边重合，则可以被记录
            if cur != prev:
                ans.append([point, cur])
                prev = cur

        return ans


b = [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]
obj = Solution()
v = obj.getSkyline(b)
print(v)

# 将左端点的高度存成负数再进行排序是什么意思？
#
# 这里只是为了方便，所以采取了这样的做法，当然也能够多使用一位来代指「左右」。
#
# 只要最终可以达到如下的排序规则即可：
#
# 1. 先严格按照横坐标进行「从小到大」排序
# 2. 对于某个横坐标而言，可能会同时出现多个点，应当按照如下规则进行处理：
#    1. 优先处理左端点，再处理右端点
#    2. 如果同样都是左端点，则按照高度「从大到小」进行处理（将高度增加到优先队列中）
#    3. 如果同样都是右端点，则按照高度「从小到大」进行处理（将高度从优先队列中删掉）
