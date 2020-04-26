class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []

        def DFS(node):
            if node:
                result.append(node.val)
                DFS(node.left)
                DFS(node.right)
        DFS(root)
        return result