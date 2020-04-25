"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# 队列解法
from collections import deque
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root == None:
            return root
        deq = deque([root])
        res = []
        while deq:
            sub_res = []
            length = len(deq)
            for i in range(length):
                node = deq.popleft()
                sub_res.append(node.val)
                if node.children!=[]:
                    deq.extend(node.children)
            res.append(sub_res)
        return res

# 递归法
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root == None:
            return root
        res = []
        def made_res(root, level):
            if len(res) == level:
                res.append([])
            res[level].append(root.val)
            if root.children!=[]:
                for child in root.children:
                    made_res(child, level+1)
        made_res(root, 0)
        return res