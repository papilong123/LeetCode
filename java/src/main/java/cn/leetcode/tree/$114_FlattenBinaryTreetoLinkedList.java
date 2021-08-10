package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

class $114_FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        while(root!=null){
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
