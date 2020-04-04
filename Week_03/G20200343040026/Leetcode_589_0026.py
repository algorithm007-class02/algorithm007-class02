"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# 递归法
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root==None:
            return []
        res = []
        res.append(root.val)
        if root.children!=[]:
            for child in root.children:
                res.extend(self.preorder(child))
        return res

# 迭代法
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root==None:
            return []
        stack = [root]
        res = []
        while stack:
            node = stack.pop()
            res.append(node.val)
            if node.children!=[]:
                for child in node.children[::-1]:
                    stack.append(child)
        return res