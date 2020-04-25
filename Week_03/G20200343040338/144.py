# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        def traversal(root: TreeNode, vals: List[int]) -> List[int]:
            if not root:
                return

            vals.append(root.val)
            traversal(root.left, vals)
            traversal(root.right, vals)

        vals = []
        traversal(root, vals)

        return vals
