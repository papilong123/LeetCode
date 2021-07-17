# -*- 二叉树 begin -*-
# 前序遍历：根结点->左子树->右子树
# 中序遍历：左子树->根结点->右子树
# 后序遍历：左子树->右子树->根结点


class Node(object):
    """节点类"""

    def __init__(self, value=None, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


class Tree(object):
    """定义二叉树类"""

    def __init__(self):
        self.root = Node()
        self.nodeList = []  # 用以存放相对的父节点，用以开辟其子节点

    def add(self, value):
        """添加节点"""
        node = Node(value)
        if self.root.value == None:  # 判断树是否是空的
            self.root = node
            self.nodeList.append(self.root)
        else:
            parentNode = self.nodeList[0]  # 给nodeList里面相对的父节点添加其子节点
            if parentNode.left == None:
                parentNode.left = node
                self.nodeList.append(parentNode.left)
            else:
                parentNode.right = node
                self.nodeList.append(parentNode.right)
                # 此时parentNode 已有两个节点，所以对它的构造完成，移除它
                self.nodeList.pop(0)

    def frontSearch(self, root):
        """递归前序遍历"""
        if root == None:
            return False
        print(root.value, end=' ')
        self.frontSearch(root.left)
        self.frontSearch(root.right)

    def midSearch(self, root):
        """递归中序遍历"""
        if root == None:
            return False
        self.midSearch(root.left)
        print(root.value, end=' '),
        self.midSearch(root.right)

    def backSearch(self, root):
        """递归后序遍历"""
        if root == None:
            return False
        self.backSearch(root.left)
        self.backSearch(root.right)
        print(root.value, end=' ')

    def frontStack(self, root):
        """利用堆栈前序遍历"""
        if root == None:
            return False
        stack = []
        node = root
        while node or stack:
            while node:  # 寻找左子树，压入栈内
                print(node.value, end=' ')
                stack.append(node)
                node = node.left
            node = stack.pop()
            node = node.right  # 开始寻找右子树

    def midStack(self, root):
        """ 利用堆栈中序遍历"""
        if root == None:
            return False
        stack = []
        node = root
        while node or stack:
            while node:  # 从根结点开始，寻找左子树，把它压入栈中
                stack.append(node)
                node = node.left
            node = stack.pop()  # while 结束代表前一个节点没有了左子树
            print(node.value, end=' ')
            node = node.right  # 然后开始寻找右子树

    def backStack(self, root):
        """利用堆栈后序遍历"""
        if root is None:
            return False
        stack1 = []
        stack2 = []
        stack1.append(root)
        while stack1:   # 找出后序遍历的逆序，存放在 stack2中
            node = stack1.pop()
            if node.left:
                stack1.append(node.left)
            if node.right:
                stack1.append(node.right)
            stack2.append(node)
        while stack2:  # 将 stack2中的元素出栈，即是后序遍历序列
            print(stack2.pop().value, end=' ')

    def levelSearch(self, root):
        """层序遍历"""
        if root is None:
            return False
        treeList = []
        treeList.append(root)
        while treeList:
            node = treeList.pop(0)  # 先进先出
            print(node.value, end=' ')
            if node.left:
                treeList.append(node.left)
            if node.right:
                treeList.append(node.right)


if __name__ == '__main__':
    print("\n树:")
    tree = Tree()
    for node in range(10):
        tree.add(node)
    tree.levelSearch(tree.root)
    print()
    tree.frontSearch(tree.root)
    print()
    tree.midSearch(tree.root)
    print()
    tree.backSearch(tree.root)
    print()
    tree.frontStack(tree.root)
    print()
    tree.midStack(tree.root)
    print()
    tree.backStack(tree.root)
    print()
