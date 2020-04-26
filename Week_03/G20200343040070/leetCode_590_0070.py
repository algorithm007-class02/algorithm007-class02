class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []
        if root is None:
            return result

        def recursion(root, result):
            for child in root.children:
                recursion(child, result)
            result.append(root.val)
        recursion(root, result)
        return result
