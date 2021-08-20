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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        queue<TreeNode*> q;
        if(root==nullptr) return res;
        //广度优先搜索
        q.push(root);
        int depth=0;//从第零层开始
        while(!q.empty()){
            deque<int> arr;
            int cnt=q.size();
            for(int i=0;i<cnt;i++){
                TreeNode* v=q.front();
                q.pop();
                if(depth%2==0) arr.push_back(v->val);
                else arr.push_front(v->val);
                if(v->left) q.push(v->left);
                if(v->right) q.push(v->right);
            }
            res.push_back(vector<int>(begin(arr),end(arr)));
            ++depth;
        }
        return res;
    }
};
