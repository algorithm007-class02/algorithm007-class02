class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        if not board:
            return []
        if board[click[0]][click[1]] == 'M':
            board[click[0]][click[1]] = 'X'
            return board
        
        x_len = len(board)
        y_len = len(board[0])
        count = 0

        def near_points(location):
            list_return = []
            x,y = location
            for i in range(x-1,x+2):
                for j in range(y-1,y+2):
                    if not [i,j] == [x,y]:
                        list_return.append([i,j])
            return list_return

        def dfs(location,net):
            x,y = location
            if x < 0 or x> x_len-1 or y< 0 or y > y_len-1 or not net[x][y]=='E':
                return
            mean_count = 0
            np_list = near_points(location)
            for p in np_list:
                if p[0] >= 0 and p[0] <= x_len-1 and p[1] >= 0 and p[1] <= y_len-1:
                    if net[p[0]][p[1]] in ['M','X']:mean_count += 1
            net[x][y] = str(mean_count) if mean_count > 0 else 'B'
            if not net[x][y] == 'B':
                return

            for p in np_list:
                dfs(p,net)
        dfs([click[0],click[1]],board)
        return board
