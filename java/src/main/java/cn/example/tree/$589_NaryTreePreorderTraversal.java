package cn.example.tree;

import cn.example.common.Node;

import java.util.ArrayList;
import java.util.List;

class $589_NaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        inOrder(root);
        return res;
    }
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            inOrder(root.children.get(i));
        }
    }
}
