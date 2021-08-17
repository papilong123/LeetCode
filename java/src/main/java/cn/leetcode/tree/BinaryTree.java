package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

public class BinaryTree {
    // 两棵二叉树是否相同，LeetCode.100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
