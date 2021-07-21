package cn.example.tree;

import cn.example.common.TreeNode;

class $700_SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root!=null){
            if(root.val==val) return root;
            else if(root.val>val) return searchBST(root.left,val);
            else if(root.val<val) return searchBST(root.right,val);
            }
        return null;

    }
}
