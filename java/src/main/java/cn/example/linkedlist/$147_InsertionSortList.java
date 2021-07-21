package cn.example.linkedlist;

import cn.example.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class $147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode L =new ListNode (0);
        ListNode pre=L,q=null;
        L.next=null;
        while(head!=null){
        pre=L;
        while(pre.next!=null&&pre.next.val<head.val){
            pre=pre.next;
        }
        q=head.next;
        head.next=pre.next;
        pre.next=head;
        head=q;
        }
        return L.next;
    }
}
