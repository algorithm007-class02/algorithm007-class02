"""
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=590 lang=py
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def postorder1(self, root):
        """
        方法一：递归
        :type root: Node
        :rtype: List[int]
        """
        # return [] if not root else [j for i in root.children for j in self.postorder1(i)] + [root.val]
        res = []
        def helper(root):
            if root:
                for node in root.children:
                    helper(node)
                res.append(root.val)
        helper(root)
        return res
    def postorder(self, root):
        """
        方法二：迭代
        :type root: Node
        :rtype: List[int]
        """
        res = []
        stack = [root]
        while stack:
            curr = stack.pop()
            if curr: 
                res.append(curr.val)
                for node in curr.children:
                    stack.append(node)
        return res[::-1]
# @lc code=end
