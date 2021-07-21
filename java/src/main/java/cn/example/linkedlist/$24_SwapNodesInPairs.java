package cn.example.linkedlist;

import cn.example.common.ListNode;

class $24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode odd = head,p = fakeHead,even = null;

        while(odd != null && odd.next != null){

            //交换
            even = odd.next;
            odd.next = even.next;
            even.next = odd;
            p.next = even;

            //进入到下一对
            p = odd;
            odd = odd.next;
        }

        return fakeHead.next;
    }
}
