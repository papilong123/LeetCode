/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode L = new ListNode(0), pre=L,p=head;
        L.next=head;

        //自己和后继都不为空
        while(p!=null&&p.next!=null){
            if(pre.next.val!=p.next.val){
                pre=pre.next;
                p=p.next;
            }
            else{
                while(p.next!=null&&p.next.val==pre.next.val)
                    p=p.next;
                pre.next=p.next;//相比I，只修改了这两行，第一行
                p=pre.next;//第二行
            }
        }

        return L.next;
    }
}
