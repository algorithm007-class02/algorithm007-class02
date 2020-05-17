class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)
        for i in range(n):
            line = [k for k in board[i] if not k == '.']
            colu = [k[i] for k in board if not k[i] == '.']
            box_list = [k[i%3*3:i%3*3+3] for k in board[i//3*3:i//3*3+3]]
            box = [i for i in box_list[0]+box_list[1]+box_list[2] if not i == '.']
            if not len(line) == len(set(line)) or not len(colu) == len(set(colu)) or not len(box) == len(set(box)):
                return False
        
        return True