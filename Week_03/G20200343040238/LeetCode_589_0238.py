"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        self.res = []
        self.backOrder(root)
        return self.res

    def backOrder(self, node):
        if not node:
            return
        self.res.append(node.val)
        for child in node.children:
            self.backOrder(child)