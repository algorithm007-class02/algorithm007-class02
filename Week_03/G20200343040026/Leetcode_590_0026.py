"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# 递归法
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if root==None:
            return []
        res = []
        for child in root.children:
            res.extend(self.postorder(child))
        res.append(root.val)
        return res

# 迭代法
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if root==None:
            return []
        stack = [root]
        res = []
        while stack:
            node = stack.pop()
            res.append(node.val)
            if node.children != []:
                for child in node.children:
                    stack.append(child)
        return res[::-1]
