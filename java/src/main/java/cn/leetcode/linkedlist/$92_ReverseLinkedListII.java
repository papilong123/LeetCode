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
class $92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
        return null;

        ListNode L=new ListNode(0);
        L.next=head;
        ListNode pre=L,s=L;

        int t=m-1;
        while(pre!=null&&t-- >0){
            pre=pre.next;
        }

        ListNode r=pre,p=r.next,tmp=pre.next,q=null;

        int count=n-m+1;
        while(p!=null&&count-- >0){
            q=p.next;
            p.next=r.next;
            r.next=p;
            p=q;
        }
        if(tmp!=null)
        tmp.next=p;

        return L.next;
    }
}
