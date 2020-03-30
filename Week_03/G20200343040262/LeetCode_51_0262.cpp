//backtracking
class Solution {
public:
    vector<vector<string>> res;
    vector<vector<string>> solveNQueens(int n) {
        vector<string> board(n, string(n, '.'));
        backtrack(board, 0);
        return res;
    }

    void backtrack(vector<string>& board, int row) {
        if (row == board.size()) {//terminate recursion
            res.push_back(board);
            return;
        }
        int n = board[row].size();
        for (int col = 0; col < n; col++) {
            if (!isOK(board, row, col)) continue;//skip when not valid
            board[row][col] = 'Q';//make decision
            backtrack(board, row + 1);
            board[row][col] = '.';//cancel decision
        }
    }
    bool isOK(vector<string> board, int row, int col) {
        int leftup = col - 1, rightup = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;//check 上面
            if (leftup >= 0) if (board[i][leftup] == 'Q') return false;//check 左上对角线
            if (rightup < board[row].size()) if (board[i][rightup] == 'Q') return false;//check 右上对角线
            leftup--;
            rightup++;
        }
        return true;
    }
};