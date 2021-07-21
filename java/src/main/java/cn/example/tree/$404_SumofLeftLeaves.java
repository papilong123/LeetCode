package cn.example.tree;

import cn.example.common.TreeNode;

class $404_SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;

        int sum=0;
        if(isleaf(root.left)){
            sum+=root.left.val;
        }
        else{
            sum+=sumOfLeftLeaves(root.left);
        }
        if(root.right!=null)
            sum+=sumOfLeftLeaves(root.right);
        return sum;
    }
    public boolean isleaf(TreeNode t){
        return (t!=null&&t.left==null&&t.right==null);
    }
}
