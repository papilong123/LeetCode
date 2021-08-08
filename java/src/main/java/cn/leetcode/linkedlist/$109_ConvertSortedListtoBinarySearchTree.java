package cn.leetcode.linkedlist;

import cn.leetcode.common.ListNode;
import cn.leetcode.common.TreeNode;


class $109_ConvertSortedListtoBinarySearchTree {
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
