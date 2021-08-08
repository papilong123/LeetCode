package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

/**
 * Definition for a binary cn.example.tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class $110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    public int helper(TreeNode t){
        if (t == null) return 0;
        int left=helper(t.left);
        if ( left==-1 ) return -1;
        int right=helper(t.right);
        if(right==-1) return -1;
        return Math.abs(left-right)>1 ? -1 : Math.max(left,right)+1;
    }
}
