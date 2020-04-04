"""
https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

 



 

返回其前序遍历: [1,3,5,6,2,4]。
"""
def preorder(root):
    res = []
    def helper(root):
        if not root:
            return
        res.append(root.val)
        for child in root.children:
            helper(child)
    helper(root)
    return res
