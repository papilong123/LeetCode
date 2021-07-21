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
class $61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode L = new ListNode(0);
        L.next=head;
        ListNode pre=L,p=head;

        //得到链表长度
        int len=0;
        while(p!=null){
            p=p.next;
            len++;
        }
        k=k%len;


        //得到中间截断节点的前驱
        p=L.next;
        for(int i=0;i<len-k-1;i++){
           p=p.next;
        }

        //拼接节点
        pre.next=p.next;
        p.next=null;
        while(pre.next!=null)
        pre=pre.next;
        pre.next=head;


        return L.next;
    }
}
