class Solution {
    int ans=1;
    public int diameterOfBinaryTree(TreeNode root) {
      if(root==null) return 0;

      helper(root);
      return ans-1;   
    }
    public int helper(TreeNode root){
        if(root==null) return 0;

        int L=helper(root.left);
        int R=helper(root.right);
        ans=Math.max(ans,L+R+1);
        return Math.max(L,R)+1;
    }
}
