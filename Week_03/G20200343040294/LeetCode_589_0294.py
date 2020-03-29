#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
# 迭代方式实现
"""
我们使用一个栈来帮助我们得到前序遍历，
需要保证栈顶的节点就是我们当前遍历到的节点。
我们首先把根节点入栈，因为根节点是前序遍历中的第一个节点。
随后每次我们从栈顶取出一个节点 u，
它是我们当前遍历到的节点，
并把 u 的所有子节点逆序推入栈中。
例如 u 的子节点从左到右为 v1, v2, v3，
那么推入栈的顺序应当为 v3, v2, v1，
这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v1）出现在栈顶的位置。
"""

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
        
        stack, output = [root, ], []            
        while stack:
            root = stack.pop()
            output.append(root.val)
            stack.extend(root.children[::-1])
        return output
        
# @lc code=end

