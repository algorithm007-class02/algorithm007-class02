# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # 维护栈进行迭代算法
        res = []
        stack = []
        curr = root
        while curr != None or len(stack) > 0:
            if curr:
                # 先序遍历 - 先放根节点
                res.append(curr.val)    
                # 遍历是先左后右，栈是后进先出->先压入右节点再压入左节点
                stack.append(curr.right)    
                stack.append(curr.left)
            curr = stack.pop()
        return res


        # 递归算法
        # res = []
        # if root:
        #     res += [root.val]
        #     res += self.preorderTraversal(root.left)
        #     res += self.preorderTraversal(root.right)
        # return res