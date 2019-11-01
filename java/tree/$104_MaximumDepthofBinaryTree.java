/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)  return 0;
        else return java.lang.Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}







//good idea recursion
class Solution {
    int max = 0;
    int depth = 0;
    
    public int maxDepth(TreeNode root) {
        backOrder(root);
        
        return max;
    }
    
    private void backOrder(TreeNode root) {
        if (root != null) {
            depth++;
            max = Math.max(max, depth);
            backOrder(root.left);
            backOrder(root.right);
            depth--;
        }
    }
}
