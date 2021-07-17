package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class $25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0,cycles=0;
        ListNode p=head,r=null;
        ListNode L =new ListNode(0) , pre=L;
        L.next=head;

        while(p!=null){
            len++;
            p=p.next;
        }
        p=head;
        cycles=len/k;
        pre.next=null;

        while(cycles-- >0){
            for(int i=0 ; i<k ; i++){
                r=p.next;
                p.next=pre.next;
                pre.next=p;
                p=r;
            }
            pre=head;
            head=p;
        }
        //接上最后一部分
        pre.next=p;

        return L.next;
    }
}
