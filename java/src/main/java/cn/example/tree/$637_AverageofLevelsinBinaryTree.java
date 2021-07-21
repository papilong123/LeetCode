package cn.example.tree;

class $637_AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        double sum=0,n=1,t;
        List<Double> ans= new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(queue.size() >0){
            n=queue.size();
            t=n;
            while(t-- >0){
                TreeNode tmp= queue.removeFirst();
                sum+=tmp.val;
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }
            ans.add(sum/n);
            sum=0;
        }
        return ans;
    }
}
