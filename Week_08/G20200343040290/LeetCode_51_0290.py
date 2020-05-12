class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        def dfs(col,pie,na):
            p = len(col)
            if p == n:
                result.append(col)
                return
            for i in range(n):
                if i not in col and i+p not in pie and i-p not in na:
                    dfs(col+[i],pie+[i+p],na+[i-p])
        dfs([],[],[])
        return [['.'*i+'Q'+'.'*(n-1-i) for i in j] for j in result]