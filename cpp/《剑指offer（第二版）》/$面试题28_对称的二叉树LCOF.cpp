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
    bool isSymmetric(TreeNode* root) {
        if(root==nullptr) return true;
        return preOrder(root->left,root->right);
    }

    //只适用于根节点非空的情况
    bool preOrder(TreeNode* L,TreeNode* R){
        if(L==nullptr && R==nullptr) return true;//若两指针同时到达空节点，返回true

        if(L==nullptr || R==nullptr || L->val!=R->val) return false;//若只有一个到达空节点，返回false

        return preOrder(L->left,R->right)&&preOrder(L->right,R->left);//继续向下递归遍历
    }
};
