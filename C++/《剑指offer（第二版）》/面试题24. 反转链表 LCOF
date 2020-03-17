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
    ListNode* reverseList(ListNode* head) {
        ListNode* pre=new ListNode(0);
        ListNode* r;
        while(head!=NULL){
            r=head->next;
            head->next=pre->next;
            pre->next=head;
            head=r;
        }
        return pre->next;
    }
};
