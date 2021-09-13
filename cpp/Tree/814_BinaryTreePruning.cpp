#include <string>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode* pruneTree(TreeNode* root) {
        if(!root) return NULL;
        root->left=pruneTree(root->left);
        root->right=pruneTree(root->right);
        if(root->val==0 && !root->left && !root->right) return NULL;//利用后序遍历剪枝，若左右节点均为空节点且自己的值为0，则返回空指针删除自己
        return root;
    }
};
