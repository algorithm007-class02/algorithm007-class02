#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # 方法3：迭代，使用栈(添加颜色标识)
        WHITE,GREY=0,1
        res=[]
        stack=[(WHITE,root)]
        while stack:
            color,node=stack.pop()
            if node is None:
                continue
            if color==WHITE:
                stack.append((WHITE,node.right))
                stack.append((GREY,node))
                stack.append((WHITE,node.left))
            else:
                res.append(node.val)
        return res


                # 方法1：递归，宏观过程思考
        # res=[]
        # def helper(root):
        #     if not root:
        #         return
        #     helper(root.left)
        #     res.append(root.val)
        #     helper(root.right)
        # helper(root)
        # return res


        # res,stack=[],[]
        # # 用p当做指针，先把左子树全部压入
        # p=root
        # while p or stack: # p是不断遍历左右孩子的，保证左右孩子一直存在，栈不为空，因为要返回全部res
        #     while p:
        #         stack.append(p) # 中序遍历，左中右，先将左全部压入stack
        #         p=p.left
        #     p=stack.pop() # 把当前最左侧的元素弹出来
        #     res.append(p.val) # 值添加到输出list里
        #     p=p.right # 再看右节点需要不需要迭代
        # return res
# @lc code=end

