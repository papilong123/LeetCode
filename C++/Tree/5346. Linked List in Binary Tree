/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for a binary cn.example.tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSubPath(ListNode* head, TreeNode* root) {
        if(head==NULL) return true;

        if(root==NULL) return false;

        //先判断当前的节点，如果不对，再看左子树和右子树呗
        return isSub(head,root) || isSubPath(head,root->left) || isSubPath(head,root->right);
    }

    bool isSub(ListNode* head,TreeNode* root){
        //特判：链表走完了，返回true
        if(head==NULL) return true;

        //特判：链表没走完，树走完了，这肯定不行，返回false
        if(root==NULL) return false;

        //如果值不同，必定不是啊
        if(head->val!=root->val) return false;

        //如果值相同，继续看，左边和右边有一个满足即可
        return isSub(head->next,root->left) || isSub(head->next,root->right);
    }
};
