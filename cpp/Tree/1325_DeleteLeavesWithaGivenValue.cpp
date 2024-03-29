#include <vector>
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
//后序遍历从叶节点开始，逐渐往上推演
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        if(!root) return NULL;

        root->left=removeLeafNodes(root->left,target);
        root->right=removeLeafNodes(root->right,target);

        if(!root->left && !root->right && root->val==target) return NULL;

        return root;
    }
};
