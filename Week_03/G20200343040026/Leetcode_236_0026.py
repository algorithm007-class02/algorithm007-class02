# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归返回父节点法
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root==None or root==p or root==q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        return root if (left and right) else (left or right)

# 递归返回bool法
class Solution:
    def __init__(self):
        self.ans = 0

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def find_ans(root, p, q):
            if root == None:
                return False

            left = find_ans(root.left, p, q)
            right = find_ans(root.right, p, q)
            mid = root == q or root == p

            if left + right + mid >= 2:
                self.ans = root

            return left or right or mid

        if find_ans(root, p, q):
            return self.ans
        else:
            return None
