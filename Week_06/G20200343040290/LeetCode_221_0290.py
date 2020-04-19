class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m,n = len(matrix),len(matrix[0])
        states = matrix
        max_len = 0
        for i in range(n):
            states[0][i] = int(matrix[0][i])
            max_len = max(max_len,states[0][i])
        for i in range(m):
            states[i][0] = int(matrix[i][0])
            max_len = max(max_len,states[i][0])
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i][j] == '1':
                    states[i][j] = min(states[i-1][j],states[i][j-1],states[i-1][j-1])+1
                    max_len = max(max_len,states[i][j])
                else: states[i][j] = 0
        return max_len*max_len
