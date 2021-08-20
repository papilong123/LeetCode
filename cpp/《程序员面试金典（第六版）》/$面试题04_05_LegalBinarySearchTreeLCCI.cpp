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
    bool isValidBST(TreeNode* root) {
        if(!root) return true;

        auto res=helper(root);
        return res[0];
    }

    vector<long long> helper(TreeNode* root){
        if(!root) return {true,LLONG_MAX,LLONG_MIN};

        auto left=helper(root->left);
        auto right=helper(root->right);

        if(!left[0] || !right[0] || root->val<=left[2] || root->val>=right[1]) return {false,0,0};

        int curmin= root->left==NULL?root->val:left[1];
        int curmax= root->right==NULL?root->val:right[2];

        return {true,curmin,curmax};
    }
};
