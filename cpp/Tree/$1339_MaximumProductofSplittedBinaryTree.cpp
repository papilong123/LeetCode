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
    vector<long> sums;
    static const int mod=1e9+7;
    int maxProduct(TreeNode* root) {
        long res=0;
        postOrder(root);
        for(int i=0;i<sums.size()-1;i++){
            res=max(res,sums[i]*(sums.back()-sums[i]));
        }
        return (int)(res%mod);
    }

    long postOrder(TreeNode* root){//后序遍历
        if(root==NULL) return 0;
        long sum=root->val+postOrder(root->left)+postOrder(root->right);
        sums.push_back(sum);
        return sum;
    }
};
