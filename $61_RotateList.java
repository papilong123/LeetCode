class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode L= new ListNode(0);
        L.next=head;
        ListNode r=L;
        int len=0;
        while(r.next!=null){
            r=r.next;
            len++;
        }
        int N=1;
        ListNode pre=L;
        while(N++<len-k+1){
            pre=pre.next;
        }
        ListNode q=pre.next;
        pre.next=null;
        L.next=q;
        r.next=head;
        return L.next;
    }
}
