package cn.leetcode.tree;

import cn.leetcode.common.Node;

import java.util.LinkedList;
import java.util.List;

class $590_NaryTreePostorderTraversal {
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
