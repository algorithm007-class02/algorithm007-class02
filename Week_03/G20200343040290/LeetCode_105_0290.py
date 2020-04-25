# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        root_index = inorder.index(preorder[0])
        left_preorder = preorder[1:root_index+1]
        left_inorder = inorder[:root_index]
        right_preorder = preorder[root_index+1:]
        right_inorder = inorder[root_index+1:]
        root.left = self.buildTree(left_preorder,left_inorder)
        root.right = self.buildTree(right_preorder,right_inorder)
        return root
