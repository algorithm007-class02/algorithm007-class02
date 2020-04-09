# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> list:
        self.res = []
        self.dfsLevelOrder(root, 0)
        return self.res

    def dfsLevelOrder(self, node, level):
        if not node:
            return
        if len(self.res) > level:
            self.res[level].append(node.val)
        else:
            self.res.append([node.val])
        self.dfsLevelOrder(node.left, level + 1)
        self.dfsLevelOrder(node.right, level + 1)