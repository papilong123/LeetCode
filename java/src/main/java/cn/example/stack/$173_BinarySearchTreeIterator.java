package cn.example.stack;

import cn.example.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class $173_BinarySearchTreeIterator {
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode p = new TreeNode();

    public $173_BinarySearchTreeIterator(TreeNode root) {
        p = root;
    }

    public int next() {
        while( p != null){
            stack.push(p);
            p = p.left;
        }
        p = stack.pop();
        int v = p.val;
        p = p.right;
        return v;
    }

    public boolean hasNext() {
        return p != null || stack.size()>0;
    }
}
