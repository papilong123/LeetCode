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
    vector<int> res;
    queue<TreeNode*> q;
    vector<int> levelOrder(TreeNode* root) {
        if(root==nullptr) return res;
        bfs(root);
        return res;
    }

    void bfs(TreeNode* root){
        q.push(root);
        while(!q.empty()){
            int cnt=q.size();
            for(int i=0;i<cnt;i++){
                TreeNode* v=q.front();
                q.pop();
                res.push_back(v->val);
                if(v->left) q.push(v->left);
                if(v->right) q.push(v->right);
            }
        }
    }
};
