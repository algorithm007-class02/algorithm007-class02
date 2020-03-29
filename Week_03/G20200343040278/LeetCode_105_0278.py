#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#

# @lc code=start
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
        p = TreeNode(preorder[0])
        i = inorder.index(preorder[0])
        p.left = self.buildTree(preorder[1:i + 1], inorder[:i])
        p.right = self.buildTree(preorder[i + 1:], inorder[i + 1:])
        return p


# @lc code=end

