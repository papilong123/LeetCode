from typing import List

from common.ListNode import ListNode
from common.PriorityQueue import PriorityQueue


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        cmp = lambda node1, node2: node1.val - node2.val
        queue = PriorityQueue(cmp)
        for root in lists:
            if root:
                queue.offer(root)
        root = ListNode(-1)
        tail = root
        while not queue.is_empty():
            node = queue.pop()
            tail.next = node
            tail = tail.next
            if node.next:
                queue.offer(node.next)
        return root.next
