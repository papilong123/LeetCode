package tree;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root==null) return ans;

        int depth=0;
        Deque<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> tmp=new LinkedList<>();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(depth%2==0) tmp.add(node.val);
                else tmp.add(0,node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            ans.add(tmp);
            depth++;
        }
        return ans;
    }
}
