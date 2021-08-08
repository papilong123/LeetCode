package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class $513_FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ans=0;
        while(!q.isEmpty()){
            int count=q.size();
            ans=q.peek().val;
            while(count-->0){
                TreeNode cur= q.poll();
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
        }
        return ans;
    }
}
