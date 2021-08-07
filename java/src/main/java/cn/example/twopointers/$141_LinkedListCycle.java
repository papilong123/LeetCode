package cn.example.twopointers;

import cn.example.common.ListNode;

public class $141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{3,2,0,-4};
        $141_LinkedListCycle solution = new $141_LinkedListCycle();
        ListNode head = solution.generateLinkedListNode(arr);
        boolean ans = solution.hasCycle(head);
        System.out.println(ans);
    }

    public ListNode generateLinkedListNode(int[] arr){
        ListNode dummyHead = new ListNode(0), r = dummyHead;
        for (int j : arr) {
            r.next = new ListNode(j);
            r = r.next;
        }
        return dummyHead.next;
    }
}
