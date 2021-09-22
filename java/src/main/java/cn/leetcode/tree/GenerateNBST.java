package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class GenerateNBST {
    // 95. 不同的二叉搜索树 II,生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generate(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generate(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    // 96. 不同的二叉搜索树,求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
    // 方法一、dp（G[0]=G[1]=1）空节点或一个节点也是BST
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    // 96. 不同的二叉搜索树
    // 方法二、卡特兰数公式
    public int numTreesFormula(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
