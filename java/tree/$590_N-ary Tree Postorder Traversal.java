class Solution {
    public List<Integer> postorder(Node root) {
    LinkedList<Integer> ans=new LinkedList<>();
    LinkedList<Node> s=new LinkedList<>();
    if(root==null) return ans;

    s.add(root);
    while(!s.isEmpty()){
        Node node=s.pollLast();
        ans.addFirst(node.val);
        for(Node term : node.children){
            if(term!=null)
            s.add(term);
        }
    }
    return ans;
    }
}
