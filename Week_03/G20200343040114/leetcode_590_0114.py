"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
#590. N叉树的后序遍历
class Solution:
    # 递归法
    # def helper(self, res, node):
    #     for child in node.children:
    #         if child:
    #             self.helper(res, child)
    #     res.append(node.val)

    # def postorder(self, root: 'Node') -> List[int]:
    #     ans = []
    #     if root is None:
    #         return None
    #     self.helper(ans, root)
    #     return ans

    def postorder(self, root: 'Node') -> List[int]:
        if root is None:
            return None
        stack, output = [root,], []
        while stack:
            v = stack.pop()
            output.append(v.val)
            stack.extend(v.children)
        return output[::-1]

