package cn.example.tree;

import cn.example.common.TreeNode;

public class $671_SecondMinimumNodeInaBinaryTree {
    int curVal;
    int res;
    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        curVal = root.val;
        preOrder(root);
        return res;
    }

    public void preOrder(TreeNode node){
        if(node != null){
//            剪枝，res已经更新过一次，碰到大于等于res的直接返回
            if(res != -1 && res <= node.val){
                return;
            }

            if(node.val > curVal){
                res = node.val;
            }

            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
