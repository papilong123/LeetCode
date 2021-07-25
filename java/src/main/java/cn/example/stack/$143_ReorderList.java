package cn.example.stack;

import cn.example.common.ListNode;

import java.util.Stack;

public class $143_ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;
        while(head != null && head.next != null){
            head = head.next.next;
            p = p.next;
        }

        p = head.next;
        head.next = null;
        while(p != null){
            st.push(p);
            p = p.next;
        }

        head = dummyNode.next;
        while(! st.empty()){
            p = st.pop();
            p.next = head.next;
            head.next = p;
            head = head.next.next;
        }
    }

}
