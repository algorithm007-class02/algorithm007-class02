# 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
# 
#  
# 
#  示例： 
# 二叉树：[3,9,20,null,null,15,7], 
# 
#      3
#    / \
#   9  20
#     /  \
#    15   7
#  
# 
#  返回其层次遍历结果： 
# 
#  [
#   [3],
#   [9,20],
#   [15,7]
# ]
#  
#  Related Topics 树 广度优先搜索

from typing import List
from collections import deque


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        """
            BFS
        :param root:
        :return:
        """
        if root is None:
            return []
        queue = [root]
        result = []
        while queue:
            child = []
            nodes = []
            for item in queue:
                child.append(item.val)
                if item.left:
                    nodes.append(item.left)
                if item.right:
                    nodes.append(item.right)
            result.append(child)
            queue = nodes
        return result
# leetcode submit region end(Prohibit modification and deletion)
