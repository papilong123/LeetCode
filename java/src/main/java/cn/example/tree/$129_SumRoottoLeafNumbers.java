package cn.example.tree;

import cn.example.common.TreeNode;

class $129_SumRoottoLeafNumbers {
    int sum=0;

    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        dfs(root,root.val);
        return sum;
    }
    public void dfs(TreeNode root,int k){
        if(root.left==null&&root.right==null){
            sum+=k;
            return;
        }
        if(root.left!=null){
            dfs(root.left,k*10+root.left.val);
        }
        if(root.right!=null){
            dfs(root.right,k*10+root.right.val);
        }
    }
}
