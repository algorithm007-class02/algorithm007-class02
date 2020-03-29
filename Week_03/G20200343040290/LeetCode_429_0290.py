"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        def helper(root,level,res):
            if not root:return
            if len(res) <= level:
                res.append([])
            res[level].append(root.val)

            for c in root.children:
                helper(c,level+1,res)
        res = []
        helper(root,0,res)
        return res
