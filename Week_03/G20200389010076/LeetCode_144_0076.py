class Solution:
    #Ϳɫ
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        white,red=0,1
        stack=[(white,root)]
        p=[]
        while stack!=[]:
            color,node=stack.pop()
            if node==None:
                continue
            if color==white:
                stack.append((white,node.right))
                stack.append((white,node.left))
                stack.append((red,node))
            else:
                p.append(node.val)
        return p
