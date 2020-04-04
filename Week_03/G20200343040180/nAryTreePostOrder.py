"""
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

 



 

返回其后序遍历: [5,6,3,2,4,1].
"""
def postOrder(root):
    if not root:
        return None
    res = []
    for child in root.children:
        postOrder(child)
    res.append(root.val)
    return res
        
