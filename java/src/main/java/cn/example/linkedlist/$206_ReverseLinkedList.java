package cn.example.linkedlist;

import cn.example.common.ListNode;

class $206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode L=new ListNode(0);
        L.next=null;
        ListNode r=new ListNode(0);
         while(head!=null){
             r=head.next;
             head.next=L.next;
             L.next=head;
             head=r;
         }
        return L.next;
    }
}
