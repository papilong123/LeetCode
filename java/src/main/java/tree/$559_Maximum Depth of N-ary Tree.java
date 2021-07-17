package tree;

class Solution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }else if(root.children.isEmpty()){
            return 1;
        }else{
            List<Integer> heights=new LinkedList<>();
            for(Node item: root.children){
                heights.add(maxDepth(item));
            }
            return Collections.max(heights)+1;
        }
    }
}
