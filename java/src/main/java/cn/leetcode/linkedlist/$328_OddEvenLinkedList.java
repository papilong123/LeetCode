package cn.leetcode.linkedlist;

import cn.leetcode.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class $328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode L=new ListNode(0);
        L.next=head;
        int i=1;
        ListNode L1=new ListNode(0),L2=new ListNode(0);
        ListNode r1=L1,r2=L2;
        while(head!=null){
            if(i%2==1){
                r1.next=head;
                r1=head;
                head=head.next;
            }else{
                r2.next=head;
                r2=head;
                head=head.next;
            }
            i++;
        }
        r1.next=L2.next;
        r2.next=null;

        return L.next;
    }
}
