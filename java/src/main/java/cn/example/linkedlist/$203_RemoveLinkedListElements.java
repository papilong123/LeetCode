package cn.example.linkedlist;

import cn.example.common.ListNode;

class $203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode L=new ListNode(0);
        L.next=head;
        ListNode pre=L;
        while(head!=null){
            if(head.val==val){
                pre.next=head.next;
                head=pre.next;
            }else{
                pre=head;
                head=head.next;
            }
        }
        return L.next;
    }
}
