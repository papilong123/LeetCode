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
    bool flag=true;
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        postOrder(root);
        return flag;
    }

    int postOrder(TreeNode* root){
        if(!root) return 0;
        int left=postOrder(root->left);
        int right=postOrder(root->right);
        if(abs(left-right)>1) flag=false;
        return max(left,right)+1;
    }
};
