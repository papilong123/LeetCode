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
class $234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        ListNode L=new ListNode(0);
        L.next=head;

        int len=0;
        int i;
        while(head!=null){
            len++;
            head=head.next;
        }
        head=L.next;
        int[] A =new int[len/2+1];

        //i的值从1开始到len/2+1，防止下标变为-1
        for(i=1;i<len/2+1;i++){
            A[i]=head.val;
            head=head.next;
        }

        //i变为最后一个数值，如果是奇数移到下一个节点
        i--;
        if(len%2==1)
            head=head.next;
        while(head!=null&&A[i]==head.val){
            i--;
            head=head.next;
        }


        if(head!=null){
            return false;
        }
        else
            return true;
    }
}







