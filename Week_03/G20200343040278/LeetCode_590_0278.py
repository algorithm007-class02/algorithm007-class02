#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        st = [root]
        res = []
        while st:
            p = st.pop()
            res.append(p.val)
            st.extend(p.children)
        return res[::-1]

# 迭代思路：
# 与前序思路相同，进孩子时正序进，出结果时反着出

        
# @lc code=end

