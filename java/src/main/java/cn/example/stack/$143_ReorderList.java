package cn.example.stack;

import cn.example.common.ListNode;

import java.util.Stack;

public class $143_ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        while(head != null && head.next != null){
            st.push(head.next);
            head.next = head.next.next;
            head = head.next;
        }

        head = dummyNode.next;
        while(! st.empty()){
            ListNode p = st.pop();
            p.next = head.next;
            head.next = p;
            head = head.next.next;
        }
    }

    public static void main(String[] args) {
        $143_ReorderList solution = new $143_ReorderList();
        ListNode arr = new ListNode(1);
        for(int i = 2; i < 5; i++){
            arr.next = new ListNode(i);
            arr = arr.next;
        }
        System.out.println(arr);
        solution.reorderList(arr);
        System.out.println(arr);
    }
}
