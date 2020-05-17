class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        def DFS(level,pie,na,res):
            if level == n:
                result.append(res)
            for i in range(n):
                if not i in res and not level+i in pie and not level-i in na:
                    DFS(level+1,pie+[level+i],na+[level-i],res+[i])
        DFS(0,[],[],[])
                     
        return [['.'*i+'Q'+'.'*(n-i-1) for i in res] for res in result]