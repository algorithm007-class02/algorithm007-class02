#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
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
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return []
        queue = [root]
        res = []
        while queue:
            temp = []
            node = []
            for item in queue:
                temp.append(item.val)
                if item.children:
                    node += item.children
            res.append(temp)
            queue = node
        return res

        
# @lc code=end
