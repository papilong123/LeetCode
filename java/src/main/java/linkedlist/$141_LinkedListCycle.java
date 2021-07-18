package linkedlist;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class $141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while(head!=null){
            if(set.contains(head))
                return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }
}
