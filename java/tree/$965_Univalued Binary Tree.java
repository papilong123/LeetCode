class Solution {
    List<Integer> vals=new ArrayList<Integer>();

    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;

        bfs(root);
        for( int v : vals ){
            if(v != vals.get(0))
            return false;
        }
        return true;
    }
    public void bfs(TreeNode root){
        if(root!=null){
            vals.add(root.val);
            bfs(root.left);
            bfs(root.right);
        }
    }
}
