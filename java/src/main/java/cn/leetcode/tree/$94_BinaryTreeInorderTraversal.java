package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary cn.example.tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class $94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    public void helper(TreeNode root, List<Integer> ans){
        if(root!=null){
            if(root.left!=null) helper(root.left,ans);
            ans.add(root.val);
            if(root.right!=null) helper(root.right,ans);
        }
    }
}
