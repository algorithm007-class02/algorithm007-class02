class Solution:
    #µü´ú ¸ù×óÓÒ
    def preorder(self, root: 'Node') -> List[int]:
        if root==None:
            return []
        stack=[root]
        p=[]
        curr=None
        while stack!=[]:
            curr=stack.pop()
            p.append(curr.val)
            stack.extend(curr.children[::-1])
        return p