package cn.example.tree;

import cn.example.common.TreeNode;

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
class $145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans=new LinkedList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();

        if(root==null) return ans;

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node= stack.pollLast();
            ans.addFirst(node.val);

            if(node.left!=null) stack.add(node.left);
            if(node.right!=null) stack.add(node.right);
        }
        return ans;
    }
}
