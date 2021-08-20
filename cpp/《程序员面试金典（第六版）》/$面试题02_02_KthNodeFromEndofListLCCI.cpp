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
    int kthToLast(ListNode* head, int k) {
        ListNode* p = head;
        ListNode* p1 = head;
        while(k-- >0){
            p=p->next;
        }
        while(p!=NULL){
            p=p->next;
            p1=p1->next;
        }
        return p1->val;
    }
};
