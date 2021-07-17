package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
        return null;
        ListNode L= new ListNode(0),L1=new ListNode(0),pre =L,r=L1;
        L.next = head;
        ListNode p=head;
        while(p!=null){
            if(p.val<x){
                ListNode q=p.next;
                pre.next=q;
                r.next=p;
                r=r.next;
                p=q;
            }else{
                pre=p;
                p=p.next;
            }
        }

        r.next=L.next;
        return L1.next;
    }
}
