/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=length(headA),lenB=length(headB),dist=0;
        ListNode longlist,shortlist;
        if(lenA>lenB){
            longlist=headA;
            shortlist=headB;
            dist=lenA-lenB;
        }else{
            longlist=headB;
            shortlist=headA;
            dist=lenB-lenA;
        }
        for(int i=0;i<dist;i++){
            longlist=longlist.next;
        }
        while(longlist!=null&&longlist!=shortlist){
            longlist=longlist.next;
            shortlist=shortlist.next;
        }
        if(longlist==null)
            return null;
        else return longlist;
    }
    public int length(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
