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


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        def _level_order(root, levels, n=0):
            if not root:
                return levels

            if len(levels) - 1 < n:
                levels.append([])

            levels[n].append(root.val)

            _level_order(root.left, levels, n + 1)
            _level_order(root.right, levels, n + 1)

            return levels

        return _level_order(root, [])