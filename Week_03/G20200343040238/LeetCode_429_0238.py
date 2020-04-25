"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        res, level_list, level = [[root.val]], [], 1
        def backOrder(node, temp_level):
            for child in node.children:
                if temp_level > len(res):
                    res.append([child.val])
                else:
                    res[temp_level - 1].append(child.val)
                backOrder(child, temp_level + 1)

        backOrder(root, level + 1)
        return res