#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        st = [root]
        res = []
        while st:
            p = st.pop()
            res.append(p.val)
            if p.right is not None:
                st.append(p.right)
            if p.left is not None:
                st.append(p.left)
        return res


# 迭代思路：
# 前序嘛，stack+孩子反进+结果正出 

# @lc code=end

