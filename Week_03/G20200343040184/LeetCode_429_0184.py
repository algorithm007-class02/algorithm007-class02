"""
/**
 * @lc app=leetcode.cn id=429 lang=py
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 链接：
 */
"""
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    # dfs
    def levelOrder1(self, root):
        """
        递归 
        :type root: Node
        :rtype: List[List[int]]
        """
        res = []
        def helper(level, root):
            if len(res) == level: res.append([])
            res[level].append(root.val)
            for node in root.children:
                helper(level + 1, node)
        if root is not None:
            helper(0, root)
        return res
    
    # bfs
    def levelOrder2(self, root):
        """
        递归
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        res = []
        layer = [root]
        while layer:
            next_layer = []
            res.append([])
            for node in layer:
                res[-1].append(node.val)
                next_layer.extend(node.children)
            layer = next_layer
        return res
# @lc code=end
