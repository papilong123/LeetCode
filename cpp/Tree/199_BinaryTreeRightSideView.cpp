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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        dfs_NRL(root,0,res);
        return res;
    }

    void dfs_NRL(TreeNode* root,int depth,vector<int>& res){
        if(root){
            if(depth==res.size()) res.emplace_back(root->val);//当深度等于结果集的元素数量时加一
            dfs_NRL(root->right,depth+1,res);
            dfs_NRL(root->left,depth+1,res);
        }
    }
};
