#include <vector>
#include <unordered_map>
using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
    unordered_map<int,int> m;
    vector<int> p;

public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for(int i=0;i<inorder.size();i++){
            m[inorder[i]]=i;
        }
        p=postorder;
        return helper(0,inorder.size()-1,0,postorder.size()-1);
    }

    TreeNode* helper(int is,int ie,int ps,int pe){
        if(is>ie || ps>pe) return NULL;

        int v=p[pe];
        int ir=m[v];

        TreeNode* node=new TreeNode(v);
        node->left=helper(is,ir-1,ps,ps+ir-1-is);
        node->right=helper(ir+1,ie,ps+ir-is,pe-1);
        return node;
    }
};
