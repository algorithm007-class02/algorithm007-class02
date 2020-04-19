"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:

        def dfs(root,res):
            if not root:
                return []
            else:
                for i in root.children:
                    dfs(i,res)
                res.append(root.val)
                
        res = []
        dfs(root,res)
        return res
