# DFS
class Solution:
    def __init__(self):
        self.dx = [-1, -1, -1, 0, 0, 1, 1, 1]
        self.dy = [-1, 0, 1, -1, 1, -1, 0, 1]
        self.visited = set()

    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        x, y = click
        if board[x][y] == 'M':
            board[x][y] = 'X'
            return board

        m, n = len(board), len(board[0])

        def helper(board, x, y):
            self.visited.add((x, y))
            if board[x][y] == 'E':
                flag = self.Mnum(board, x, y, m, n)
                print(flag)
                if flag > 0:
                    board[x][y] = str(flag)
                if flag == 0:
                    board[x][y] = 'B'
                    for i in range(8):
                        nx = x + self.dx[i]
                        ny = y + self.dy[i]
                        if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in self.visited:
                            helper(board, nx, ny)
            return

        helper(board, x, y)
        return board

    def Mnum(self, board, x, y, m, n):
        num = 0
        for i in range(8):
            nx = x + self.dx[i]
            ny = y + self.dy[i]
            if 0 <= nx < m and 0 <= ny < n:
                if board[nx][ny] == 'M':
                    num += 1
        return num