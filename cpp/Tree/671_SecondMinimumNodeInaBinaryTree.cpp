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
    int res,base;
    int findSecondMinimumValue(TreeNode* root) {
        res=base=root->val;
        preOrder(root);
        return res==base?-1:res;
    }

    void preOrder(TreeNode* root){
        if(root){
            if(root->val>base){//若碰到的元素比根元素值大
                if(res==base){//第一次碰到比第一个元素更大的值
                    res=root->val;
                }else{
                    res=min(res,root->val);
                }
            }
        preOrder(root->left);
        preOrder(root->right);
        }
    }
};
