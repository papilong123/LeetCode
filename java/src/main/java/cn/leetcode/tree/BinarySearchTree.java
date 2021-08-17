package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinarySearchTree extends BaseBinarySearchTree {
    // 98. 验证是否是二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBSTHelper(node.left, lower, node.val) && isValidBSTHelper(node.right, node.val, upper);
    }

    // 99. 恢复二叉搜索树,树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树
    public void recoverTree(TreeNode root) {
        TreeNode firstnode = null, secondnode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE), p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstnode == null && pre.val > p.val) firstnode = pre;
            if (firstnode != null && pre.val > p.val) secondnode = p;
            pre = p;
            p = p.right;
        }
        // 交换两个节点
        int tmp = firstnode.val;
        firstnode.val = secondnode.val;
        secondnode.val = tmp;
    }

    // 235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

}
