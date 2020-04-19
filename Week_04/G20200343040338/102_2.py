"""
>>> n1 = TreeNode(3)
>>> n2 = TreeNode(9)
>>> n3 = TreeNode(20)
>>> n4 = TreeNode(15)
>>> n5 = TreeNode(7)
>>> n1.left = n2
>>> n1.right = n3
>>> n3.left = n4
>>> n3.right = n5
>>>
>>> s = Solution()
>>> s.levelOrder(n1)
[[3], [9, 20], [15, 7]]
"""
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return '{}'.format(self.val)


class Solution:

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = []
        queue = [(root, 0)]

        while queue:
            node, level = queue.pop(0)

            if len(levels) - 1 < level:
                levels.append([])

            levels[level].append(node.val)

            if node.left:
                queue.append((node.left, level + 1))

            if node.right:
                queue.append((node.right, level + 1))

        return levels
