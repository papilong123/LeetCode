from typing import List

from common.ListNode import ListNode


class Solution:
    def nextLargerNodes(self, head: ListNode) -> List[int]:
        p = head
        n = 0
        while p:
            n += 1
            p = p.next
        stk = []
        i = 0
        res = [0] * n  # 初始化为0
        while head:
            while stk and stk[-1][0] < head.val:
                cur, cur_idx = stk.pop()
                res[cur_idx] = head.val  # 弹出时是用字典记录到答案列表
            stk.append((head.val, i))  # 值和下标都入栈
            i += 1  # 自己记录下标
            head = head.next
        return res
