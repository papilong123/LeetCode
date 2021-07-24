package cn.example.tree;

import cn.example.common.TreeNode;

class $572_SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(s.val==t.val) return isEqual(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }


    //判断相同
    public boolean isEqual(TreeNode s,TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(s.val==t.val) return isEqual(s.left,t.left)&&isEqual(s.right,t.right);
        return false;
    }
}
