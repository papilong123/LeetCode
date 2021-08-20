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
    int cn.example.dp[50005][2],res,level;
    int longestZigZag(TreeNode* root) {
        cn.example.dp[0][0]=cn.example.dp[0][1]=-1;//叶子节点
        res=level=0;//结果和层都初始化为一
        work(root);//遍历
        return res;
    }

    int work(TreeNode* root){//传过来的层次比root所在层高一层
        if(root==NULL) return 0;
        int x=++level;//此时相匹配
        res=max(res,max(cn.example.dp[x][0]=cn.example.dp[work(root->left)][1]+1,cn.example.dp[x][1]=cn.example.dp[work(root->right)][0]+1));//左边的值等于左节点的右值+1(1是边);
        return x;
    }
};


class Solution {
    int ans=0;
    void dfs(TreeNode* root,int dir,int dis){
        if(!root)return;
        ans=max(ans,dis);
        if(dir){
            dfs(root->left,0,dis+1);
            dfs(root->right,1,1);
        }
        else{
            dfs(root->left,0,1);
            dfs(root->right,1,dis+1);
        }
    }
public:
    int longestZigZag(TreeNode* root) {
        dfs(root->left,0,1);//0左节点
        dfs(root->right,1,1);//1右结点
        return ans;
    }
};
