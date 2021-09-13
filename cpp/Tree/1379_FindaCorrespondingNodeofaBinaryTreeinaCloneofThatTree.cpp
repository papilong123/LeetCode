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
//前序遍历返回结点指针
//若是空指针直接返回空指针，若是目标结果则截断当前数值直接返回，一路返回结果值
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        if(!original) return NULL;
        if(original==target) return cloned;
        TreeNode* left=getTargetCopy(original->left,cloned->left,target);
        if(left!=NULL) return left;
        TreeNode* right=getTargetCopy(original->right,cloned->right,target);
        if(right!=NULL) return right;
        return NULL;
    }
};
