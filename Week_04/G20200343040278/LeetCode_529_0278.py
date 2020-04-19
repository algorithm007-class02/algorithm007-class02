#
# @lc app=leetcode.cn id=529 lang=python3
#
# [529] 扫雷游戏
#

# @lc code=start
class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        x, y = click[0], click[1]
        m, n = len(board), len(board[0])
        locate = [(1, -1), (1, 0), (1, 1), (0, -1), (0, 1), (-1, -1), (-1, 0), (-1, 1)]

        def DFSMarking(i, j):
            cnt = 0
            for l in locate:
                if i + l[0] >= 0 and i + l[0] < m and j + l[1] >= 0 and j + l[1] < n and board[i + l[0]][j + l[1]] == 'M':
                    cnt += 1
            if cnt > 0:
                board[i][j] = str(cnt)
            else:
                board[i][j] = 'B'
                for l in locate:
                    if i + l[0] >= 0 and i + l[0] < m and j + l[1] >= 0 and j + l[1] < n and board[i + l[0]][j + l[1]] == 'E':
                        DFSMarking(i + l[0], j + l[1])

        if board[x][y] == 'M':
            board[x][y] = 'X'
        else:
            DFSMarking(x, y)
        return board

# @lc code=end

