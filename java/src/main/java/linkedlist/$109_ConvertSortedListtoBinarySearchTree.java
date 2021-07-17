package linkedlist; /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode findMiddleElement(ListNode head){

        //同一点出发的快慢指针
        ListNode pre=null,fast=head,low=head;
        while(fast!=null&&fast.next!=null){
            pre=low;
            low=low.next;
            fast=fast.next.next;
        }

        if(pre != null){
            pre.next=null;
        }
        return low;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        return null;

        ListNode mid = this.findMiddleElement(head);
        TreeNode Node = new TreeNode(mid.val);

        if(head==mid)
        return Node;

        Node.left = this.sortedListToBST(head);
        Node.right = this.sortedListToBST(mid.next);
        return Node;
    }
}
