class Solution:
    def findCircleNum(self, M: list) -> int:
        res = 0
        seen = set()

        def dfs(row):
            for col, val in enumerate(M[row]):
                if val and col not in seen:
                    seen.add(col)
                    dfs(col)
        for i in range(len(M)):
            if i not in seen:
                dfs(i)
                res += 1
        return res