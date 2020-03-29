# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        self.res = []
        self.preTraver(root)
        return self.res

    def preTraver(self, node: TreeNode) -> None:
        if not node:
            return
        self.res.append(node.val)
        self.preTraver(node.left)
        self.preTraver(node.right)