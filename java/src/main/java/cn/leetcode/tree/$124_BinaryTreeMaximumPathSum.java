package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

class $124_BinaryTreeMaximumPathSum {
    int sum=Integer.MIN_VALUE;

    public int helper(TreeNode root){
        if(root==null) return 0;

        int left=Math.max(helper(root.left),0);
        int right=Math.max(helper(root.right),0);

        //update maximum sum of path
        sum=Math.max(left+right+root.val,sum);

        //return the max gain if continue the same path
        return root.val+Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }
}
