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
    vector<int> res;
    vector<int> reversePrint(ListNode* head) {
        recursion(head);
        return res;
    }
    void recursion(ListNode* head){
        if(!head) return;
        recursion(head->next);
        res.push_back(head->val);
    }
};
