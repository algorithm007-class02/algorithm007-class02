#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
#

# @lc code=start

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        st = [root]
        res = []
        while st:
            p = st.pop()
            res.append(p.val)
            st.extend(p.children[::-1])
        return res

# 思路1：递归
# 思路2：迭代：
#   ① 使用stack保存根节点，先入后出
#   ② 存孩子时是倒序 

# @lc code=end

