# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        def helper(root,res):
            if not root:
                return []
            else:
                res.append(root.val)
                helper(root.left,res)
                helper(root.right,res)
        res = []
        helper(root,res)
        return res
