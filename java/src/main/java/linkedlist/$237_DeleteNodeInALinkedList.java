package linkedlist;

import common.ListNode;

class $237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
