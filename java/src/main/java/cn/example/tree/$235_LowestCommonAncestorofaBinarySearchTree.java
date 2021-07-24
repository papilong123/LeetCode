package cn.example.tree;

import cn.example.common.TreeNode;

class $235_LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parval=root.val;
        int pval=p.val;
        int qval=q.val;

        if(pval>parval&&qval>parval){
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(pval<parval&&qval<parval){
            return lowestCommonAncestor(root.left,p,q);
        }
        else{
            return root;
        }
    }
}
