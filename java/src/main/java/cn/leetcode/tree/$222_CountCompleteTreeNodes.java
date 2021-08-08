package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

class $222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int left=hight(root.left);
        int right=hight(root.right);
        if(left==right){
            return countNodes(root.right)+(1<<left);
        }
        else {
            return countNodes(root.left)+(1<<right);
        }
    }
    public int hight(TreeNode root){
        int h=0;
        while(root!=null){
            root=root.left;
            h++;
        }
        return h;
    }
}
