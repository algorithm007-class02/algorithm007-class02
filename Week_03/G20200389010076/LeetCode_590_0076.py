class Solution:
    #ตÝน้
    def postorder(self, root: 'Node') -> List[int]:
        curr=None
        stack=[root]
        p=[]
        while stack!=[]:
            curr=stack.pop()
            if curr is not None:
                p.append(curr.val)
            for child in curr.children:
                stack.append(child)
        return reversed(p)