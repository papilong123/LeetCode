package tree;

class $155_MinStack {
    public void recoverTree(TreeNode root) {
        TreeNode firstnode=null;
        TreeNode secondnode=null;
        TreeNode pre=new TreeNode(Integer.MIN_VALUE);
        TreeNode p=root;
        Deque<TreeNode> stack=new LinkedList<>();

        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            if(firstnode==null&&pre.val>p.val) firstnode=pre;
            if(firstnode!=null&&pre.val>p.val) secondnode=p;
            pre=p;
            p=p.right;
        }
        int tmp=firstnode.val;
        firstnode.val=secondnode.val;
        secondnode.val=tmp;
    }
}
