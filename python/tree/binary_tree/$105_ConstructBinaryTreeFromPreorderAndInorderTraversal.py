from typing import List

from common.TreeNode import TreeNode


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        n = len(preorder)
        value2idx = {v: i for i, v in enumerate(inorder)}

        def dfs(pre_order_left, pre_order_right, in_order_left, in_order_right):
            if in_order_left > in_order_right:
                return None
            root_value = preorder[pre_order_left]
            size_left_tree = value2idx[root_value] - in_order_left
            root = TreeNode(root_value)
            root.left = dfs(pre_order_left + 1, pre_order_right, in_order_left, in_order_left + size_left_tree - 1)
            root.right = dfs(pre_order_left + size_left_tree + 1, pre_order_right, in_order_left + size_left_tree + 1,
                             in_order_right)
            return root

        r = dfs(0, n - 1, 0, n - 1)
        return r
