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
    ListNode* deleteNode(ListNode* head, int val) {
        ListNode* dummy=new ListNode(0);
        ListNode* pre=dummy;
        pre->next=head;
        while(pre->next!=nullptr){
            if(pre->next->val==val){
                pre->next=pre->next->next;
            }else{
                pre=pre->next;
            }
        }
        return dummy->next;
    }
};
