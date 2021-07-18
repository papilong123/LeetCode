package linkedlist;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class $725_SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans=new ListNode[k];
        ListNode p=root;
        int len=0;
        while(p!=null){
            len++;
            p=p.next;
        }
        p=root;

        if(len<=k){
            for (int i = 0; i < len; i++){
                ans[i]=new ListNode(p.val);
                p=p.next;
            }
        }
        else{

            int remain =len%k;
            int precount=len/k;
            int[] counts=new int[k];
            for(int i=0;i<k;i++){
                counts[i]= remain-- >0 ? precount+1 : precount;
            }

            for(int i=0;i<k;i++){
                ans[i]=p;
                while(--counts[i] >0){
                    p=p.next;
                }
                ListNode tmp=p.next;
                p.next=null;
                p=tmp;
            }
        }

        return ans;
    }
}










