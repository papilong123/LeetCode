package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

class $230_KthSmallestElementinaBST {
    private int val=0;
    private int i=0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return k;
    }
    public void helper(TreeNode root, int k){
        if(root!=null){
            helper(root.left,k);
            if(++i == k) val=root.val;
            helper(root.right,k);
        }
    }
}
