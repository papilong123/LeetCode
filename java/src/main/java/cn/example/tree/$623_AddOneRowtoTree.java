package cn.example.tree;

import cn.example.common.TreeNode;

class $623_AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode t=new TreeNode(v);
            t.left=root;
            return t;
        }
        helper(root,v,d,1);
        return root;
    }

    public void helper(TreeNode root, int v, int d,int depth){
        if(root!=null){
            if(depth==d-1){
                TreeNode t= root.left;
                root.left=new TreeNode(v);
                root.left.left=t;
                t=root.right;
                root.right=new TreeNode(v);
                root.right.right=t;
            }else{
                helper(root.left,v,d,depth+1);
                helper(root.right,v,d,depth+1);
            }
        }
    }
}
