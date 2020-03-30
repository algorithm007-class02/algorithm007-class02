"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        def dfs(root,res):
            if not root:
                return []
            else:
                res.append(root.val)
                for child in root.children:
                    dfs(child,res)
        res = []
        dfs(root,res)
        return res
