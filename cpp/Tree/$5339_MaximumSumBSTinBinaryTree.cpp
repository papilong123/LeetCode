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
    int maxsum=0;
    int maxSumBST(TreeNode* root) {
        postOrder(root);
        return maxsum;
    }

    vector<int> postOrder(TreeNode* root){
        if(!root) return {true,INT_MAX,INT_MIN,0};
        auto lchild=postOrder(root->left);
        auto rchild=postOrder(root->right);
        if(!lchild[0] || !rchild[0] || lchild[2]>=root->val || rchild[1]<=root->val){
            return {false,0,0,0};
        }
        int curmin= root->left==NULL?root->val:lchild[1];
        int curmax= root->right==NULL?root->val:rchild[2];
        int sum=lchild[3]+rchild[3]+root->val;
        maxsum=max(maxsum,sum);
        return {true,curmin,curmax,sum};
    }
};

//当前节点为根的树是不是二叉搜索树和几个状态有关

左子树是不是二叉搜索树
右子树是不是二叉搜索树
当前val是不是大于左子树最大val
当前val是不是小于右子树最小val
我们确定root节点为根的树是不是二叉搜索树，需要其左右子树处理时返回四个值

子树是不是二叉搜索树 vec[0]
子树的最小值 vec[1]
子树的最大值 vec[2]
子树的sum值 vec[3]
根据左右子节点返回值，构造当前节点的返回
当左右子树的任一vec[0]为false，或者当前val <= 左子vec[2] 或者val >= 右子vec[1]时返回 {false,随意，随意，随意}
如果判断当前树是搜索树，则返回 {true, 左子v[1], 右子v[2], val + 左子v[3] + 右子v[3]}
另外注意的是null的处理，我这里返回了{true, INT_MAX, INT_MIN, 0}。

