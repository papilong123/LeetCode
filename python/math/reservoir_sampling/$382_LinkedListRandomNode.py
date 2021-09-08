import random
from typing import Optional

from common.ListNode import ListNode


# 蓄水池抽样算法
# 当内存无法加载全部数据时，如何从包含未知大小的数据流中随机选取k个数据，并且要保证每个数据被抽取到的概率相等。
class Solution:

    def __init__(self, head: Optional[ListNode]):
        # head保证不为None
        self.head = head

    # 每次只保留一个数，当遇到第 i 个数时，以 1/i的概率保留它，(i-1)/i的概率保留原来的数。
    def getRandom(self) -> int:
        # 返回一个随机节点值
        count = 0
        reserve = 0
        cur = self.head
        while cur:
            count += 1  # 记录当前遍历到的链表长度
            rand = random.randint(1, count)  # 得到[1, count]中随机一个数，没一个数被取的概率为1/count
            if rand == count:  # 如果这个数等于count
                reserve = cur.val
            cur = cur.next
        return reserve

# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()
