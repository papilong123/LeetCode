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
class $83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode L = new ListNode(0), pre=L,p=head;
        L.next=head;

        //这个结束条件好奇怪，自己和后继都不为空
        while(p!=null&&p.next!=null){
            if(pre.next.val!=p.next.val){
                pre=pre.next;
                p=p.next;
            }
            else{
                while(p.next!=null&&p.next.val==pre.next.val)
                    p=p.next;
                pre.next=p;
                pre=p;
                p=pre.next;
            }
        }

        return L.next;
    }
}
