package cn.example.tree;

import cn.example.common.TreeNode;

/**
 * Definition for a binary cn.example.tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *三行结束问题
 */
class $101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null) return true;
        if(t1==null||t2==null) return false;
        return (t1.val==t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}
