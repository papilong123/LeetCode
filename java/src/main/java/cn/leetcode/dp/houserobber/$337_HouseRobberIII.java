package cn.leetcode.dp.houserobber;

import cn.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 后序遍历，哈希表存储选择两个选择函数
public class $337_HouseRobberIII {
    Map<TreeNode, Integer> f = new HashMap<>(), g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        // 根节点选还是不选两种情况
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
