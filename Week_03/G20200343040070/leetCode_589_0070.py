class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        # 第一句代表 q = [root] if root else false,非常精妙
        result, q =[], root and [root]
        while q:
            node = q.pop()
            result.append(node.val)
            q +=[child for child in reversed(node.children) if child]
        return result