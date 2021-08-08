package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $863_AllNodesDistanceKinBinaryTree {
    Map<Integer, TreeNode> hashmap = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //从root出发DFS，记录每个节点的父节点
        findParents(root);

        ////从target出发DFS，找到指定深度的节点
        findRes(target, null, 0, k);

        return res;
    }

    public void findParents(TreeNode node){
        if(node.left != null){
            hashmap.put(node.left.val, node);
            findParents(node.left);
        }
        if(node.right != null){
            hashmap.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findRes(TreeNode node, TreeNode from, int depth, int k){
        if(node != null){
            if (depth == k){
                res.add(node.val);
                return;
            }

            if(node.left != from){
                findRes(node.left, node, depth + 1, k);
            }

            if(node.right != from){
                findRes(node.right, node, depth + 1, k);
            }

            if (hashmap.get(node.val) != from) {
                findRes(hashmap.get(node.val), node, depth + 1, k);
            }
        }
    }
}
