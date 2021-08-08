package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.LinkedList;
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
class $144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ans=new LinkedList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();

        if(root==null) return ans;

        stack.add(root);
        while(!stack.isEmpty()){

            TreeNode node= stack.pollLast();
            ans.add(node.val);

            if(node.right!=null) stack.add(node.right);
            if(node.left!=null) stack.add(node.left);
        }
        return ans;
    }
}
