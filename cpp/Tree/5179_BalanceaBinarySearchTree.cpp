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
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> arr;
        buildarr(root,arr);
        TreeNode* avl=new TreeNode(0);
        avl=sortedArrayToBST(arr);
        return avl;
    }

    void buildarr(TreeNode* root,vector<int>& arr){
        if(root){
            buildarr(root->left,arr);
            arr.emplace_back(root->val);
            buildarr(root->right,arr);
        }
    }


    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if(nums.empty()) return NULL;

        TreeNode* node=new TreeNode(1);
        node->val=nums[nums.size()/2];
        vector<int> leftarray(nums.begin(),nums.begin()+nums.size()/2);
        vector<int> rightarray(nums.begin()+nums.size()/2+1,nums.end());
        node->left=sortedArrayToBST(leftarray);
        node->right=sortedArrayToBST(rightarray);
        return node;
    }
};
