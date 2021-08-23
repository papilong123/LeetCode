from bisect import bisect_left, bisect_right

from sortedcontainers import SortedList

lt = SortedList([0, 0, 1, 1, 4, 4, 5, 8])
l = bisect_left(lt, 4)  # 返回的是下标4，查找的是4左侧的插入位置。
r = bisect_right(lt, 4)  # 返回的是下标6，查找的是4右侧的插入位置。
# 就是说，若一个值存在，left,查找的是这个值左侧的插入位置，right查找的是右侧的插入位置。
# 在举一个例子
idx1 = bisect_left(lt, 5)
idx2 = bisect_right(lt, 5)
# 数组中5只有一个，
# idx1 = 6, 表示在5左侧插入的位置也表示第一个5出现的位置，idx2 = 7，表示在右侧插入的位置。

lt = SortedList()
lt.add(8)
# 红黑树，相当于Java中的TreeSet, 用于对列表排序，还有SortedDict, SortedSet
