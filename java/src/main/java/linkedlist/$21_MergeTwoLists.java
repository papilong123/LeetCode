package linkedlist;

class $21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3= new ListNode(0),r3=l3;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                r3.next=l1;
                l1=l1.next;
            }
            else{
                r3.next=l2;
                l2=l2.next;
            }
            r3=r3.next;
        }
        r3.next= l1==null ?l2:l1;

        return l3.next;
    }
}
