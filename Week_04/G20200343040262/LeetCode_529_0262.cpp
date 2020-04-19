class Solution {
private:
    int row;
    int col;
    vector<vector<int>> neighbors = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1,1}, {1, -1}, {-1,1}, {-1, -1}};
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        vector<vector<char>> res;
        row = board.size();
        col = board[0].size();
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        markBoard(board, i, j);
        return board;
    }

    void markBoard(vector<vector<char>>& board, int i, int j) {
        if (i < 0 && i >= row && j < 0 && j >= col) return;
        if (board[i][j] == 'E') {
            int count = 0;
            for (int k = 0; k < 8; k++) {
                int new_i = i + neighbors[k][0];
                int new_j = j + neighbors[k][1];
                if (new_i >= 0 && new_i < row && new_j >= 0 && new_j < col && board[new_i][new_j] == 'M') count++;
            }
            if (count > 0) {
                board[i][j] = count + '0';
            }
            else {
                board[i][j] = 'B';
                for (int k = 0; k < 8; k++) {
                    int new_i = i + neighbors[k][0];
                    int new_j = j + neighbors[k][1];
                    if (new_i >= 0 && new_i < row && new_j >= 0 && new_j < col && board[new_i][new_j] == 'E') {
                        markBoard(board, new_i, new_j);//递归揭露B相邻方块
                }
            }
            }
        }
    }
};