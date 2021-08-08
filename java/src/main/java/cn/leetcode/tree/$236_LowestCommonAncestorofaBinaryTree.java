package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

class $236_LowestCommonAncestorofaBinaryTree {
    private TreeNode ans=null;

    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return false;

        int left= helper(root.left,p,q)?1:0;
        int right= helper(root.right,p,q)?1:0;
        int mid= (root==p||root==q)?1:0;

        if(mid+left+right>=2) ans=root;

        return (mid+left+right>=1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }
}
