package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

class $257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths=new LinkedList<String>();
        helper(root,"",paths);
        return paths;
    }

    public void helper(TreeNode root,String path,LinkedList<String> paths){
        if(root!=null){
            path+=Integer.toString(root.val);

            if(root.left==null&&root.right==null){
                paths.add(path);
            }
            else{
                path+="->";
                helper(root.left,path,paths);
                helper(root.right,path,paths);
            }
        }
    }
}
