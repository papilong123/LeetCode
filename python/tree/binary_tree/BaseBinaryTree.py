from typing import List

from common.TreeNode import TreeNode


class BaseBinaryTree:

    # 104. 二叉树的最大深度
    def maxDepth(self, root):
        if root is None:
            return 0
        else:
            left_height = self.maxDepth(root.left)
            right_height = self.maxDepth(root.right)
            return max(left_height, right_height) + 1

    # 111. 二叉树的最小深度
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0

        if not root.left and not root.right:
            return 1

        min_depth = 10 ** 9
        if root.left:
            min_depth = min(self.minDepth(root.left), min_depth)
        if root.right:
            min_depth = min(self.minDepth(root.right), min_depth)

        return min_depth + 1

    # 662. 二叉树最大宽度
    def widthOfBinaryTree(self, root):
        queue = [(root, 0, 0)]
        cur_depth = left = ans = 0
        for node, depth, pos in queue:
            if node:
                queue.append((node.left, depth + 1, pos * 2))
                queue.append((node.right, depth + 1, pos * 2 + 1))
                if cur_depth != depth:
                    cur_depth = depth
                    left = pos
                ans = max(pos - left + 1, ans)

        return ans

    # 144. 二叉树的前序遍历
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        if not root:
            return res

        p = root
        while stack or p:
            while p:
                res.append(p.val)  # 这里访问
                stack.append(p)
                p = p.left
            p = stack.pop()
            p = p.right
        return res

    # 94. 二叉树的中序遍历
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        if not root:
            return res

        p = root
        while stack or p:
            while p:
                stack.append(p)
                p = p.left
            p = stack.pop()
            res.append(p.val)  # 这里访问
            p = p.right
        return res

    # 145. 二叉树的后序遍历
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        if not root:
            return []

        prev = None
        p = root
        while stack or p:
            while p:
                stack.append(p)
                p = p.left
            p = stack.pop()
            # 比前序和中序的模板增加一个判断过程：节点没有右孩子或已经访问了该节点的子节点
            if not p.right or p.right == prev:
                res.append(p.val)
                prev = p
                p = None
            else:
                stack.append(p)
                p = p.right
        return res

    # 102. 二叉树的层序遍历
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if not root:
            return []

        stack = [root]
        while stack:
            curr_lay = []
            next_lay = []
            for node in stack:
                curr_lay.append(node.val)
                if node.left:
                    next_lay.append(node.left)
                if node.right:
                    next_lay.append(node.right)
            stack = next_lay
            result.append(curr_lay)
        return result

    # 297. 二叉树的序列化与反序列化
    def serialize(self, root):
        """Encodes a tree to a single string.
        返回该树的前序遍历结果“[1, 2, None, None, 3, 4, None, None, 5, None, None]”
        :type root: TreeNode
        :rtype: str
        """

        def dfs(root):
            if not root:
                return [None]
            left_t = dfs(root.left)
            right_t = dfs(root.right)
            return [root.val] + left_t + right_t

        print(dfs(root))
        return str(dfs(root))

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        由前序遍历的list返回这棵树
        :type data: str
        :rtype: TreeNode
        """
        data_list = eval(data)  # 解析出字符串中的list

        def dfs(data_l):
            root_val = data_list.pop(0)
            if root_val is None:  # 因为data_l中含有0元素所以这里不能用if not root_val
                return None
            root = TreeNode(root_val)
            root.left = dfs(data_l)
            root.right = dfs(data_l)
            return root

        return dfs(data_list)


if __name__ == '__main__':
    s = "[1,2,None,None,3,4,None,None,5,None,None]"
    tree = BaseBinaryTree().deserialize(s)
    print()
    serialized_str = BaseBinaryTree().serialize(tree)
    print(serialized_str)
