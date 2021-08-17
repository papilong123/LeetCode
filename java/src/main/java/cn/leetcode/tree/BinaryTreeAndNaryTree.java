package cn.leetcode.tree;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
}
*/

import cn.leetcode.common.NaryNode;
import cn.leetcode.common.Pair;
import cn.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;


public class BinaryTreeAndNaryTree {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encodeNaryTreeToBinaryTree(NaryNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        Pair<TreeNode, NaryNode> head = new Pair<>(newRoot, root);

        // Add the first element to kickoff the loop
        Queue<Pair<TreeNode, NaryNode>> queue = new ArrayDeque<>();
        queue.add(head);

        while (queue.size() > 0) {
            Pair<TreeNode, NaryNode> pair = queue.remove();
            TreeNode bNode = pair.first;
            NaryNode nNode = pair.second;

            // Encoding the children nodes into a list of TreeNode.
            TreeNode prevBNode = null, headBNode = null;
            for (NaryNode nChild : nNode.children) {
                TreeNode newBNode = new TreeNode(nChild.val);
                if (prevBNode == null) {
                    headBNode = newBNode;
                } else {
                    prevBNode.right = newBNode;
                }
                prevBNode = newBNode;

                Pair<TreeNode, NaryNode> nextEntry = new Pair<>(newBNode, nChild);
                queue.add(nextEntry);
            }

            // Attach the list of children to the left node.
            bNode.left = headBNode;
        }

        return newRoot;
    }

}
