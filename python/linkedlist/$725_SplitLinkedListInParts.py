from typing import List

from common.ListNode import ListNode


class Solution:
    def splitListToParts(self, head: ListNode, k: int) -> List[ListNode]:
        cur, n = head, 0
        while cur:
            n += 1
            cur = cur.next
        each, remain = n // k, n % k
        cur, res, idx = head, [None] * k, 0

        while cur:
            res[idx] = cur
            last = None
            for _ in range(each + (idx < remain)):
                last = cur
                cur = cur.next
            last.next = None
            idx += 1

        return res


arr = [1, 2, 3]
_k = 5
hair = ListNode()
p = hair
for i in arr:
    p.next = ListNode(i)
    p = p.next
pr = Solution().splitListToParts(hair.next, _k)
print(pr)
