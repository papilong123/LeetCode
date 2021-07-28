package cn.example.stack;

import cn.example.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class $445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();
        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode ans = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int v1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int v2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = carry + v1 + v2;
            carry = sum / 10;
            int remain = sum % 10;
            ListNode curNode = new ListNode(remain);
            curNode.next = ans;
            ans = curNode;
        }
        return ans;
    }
}
