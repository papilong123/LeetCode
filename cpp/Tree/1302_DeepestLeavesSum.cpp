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
    int maxdepth=-1,res=0;
    int deepestLeavesSum(TreeNode* root) {
        dfs(root,1);
        return res;
    }

    void dfs(TreeNode* root,int depth){
        if(!root) return;
        if(depth==maxdepth) res+=root->val;
        if(depth>maxdepth) res=root->val,maxdepth=depth;
        dfs(root->left,depth+1);
        dfs(root->right,depth+1);
    }
};
