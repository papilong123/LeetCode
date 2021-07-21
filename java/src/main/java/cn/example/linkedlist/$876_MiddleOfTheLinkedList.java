package cn.example.linkedlist;

import cn.example.common.ListNode;

class $876_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}

