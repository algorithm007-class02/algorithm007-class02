class Solution:
    # ตÝน้
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        def helper(node, level):
            if len(result) == level:
                result.append([])
            result[level].append(node.val)
            for child in node.children:
                helper(child, level + 1)

        result = []
        if root != None:
            helper(root, 0)
        return result