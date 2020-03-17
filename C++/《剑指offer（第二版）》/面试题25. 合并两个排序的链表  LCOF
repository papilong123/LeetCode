/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* pre=new ListNode(1);
        ListNode* r=pre;
        while(l1!=NULL && l2!=NULL){
            if(l1->val<=l2->val){
                r->next=l1;
                r=l1;
                l1=l1->next;
            }else{
                r->next=l2;
                r=l2;
                l2=l2->next;
            }
        }
        r->next= l1!=NULL ? l1 : l2;
        return pre->next;
    }
};
