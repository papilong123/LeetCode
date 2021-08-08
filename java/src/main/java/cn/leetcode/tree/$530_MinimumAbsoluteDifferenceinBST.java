package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

class $530_MinimumAbsoluteDifferenceinBST {
    TreeNode pre= null;
    int ans=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ans;
    }

    public void helper(TreeNode root){
        if(root!=null){
            helper(root.left);
            if(pre!=null){
                ans=Math.min(ans,Math.abs(root.val-pre.val));
            }
            pre=root;
            helper(root.right);
        }
    }
}
