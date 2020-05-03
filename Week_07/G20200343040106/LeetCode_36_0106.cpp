class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<vector<bool>> row = vector(9,vector<bool>(10,false));
        vector<vector<bool>> col = vector(9,vector<bool>(10,false));
        vector<vector<bool>> box = vector(9,vector<bool>(10,false));

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(row[i][board[i][j]-'0']||col[j][board[i][j]-'0']||box[(i/3)*3+j/3][board[i][j]-'0'])
                    return false;
                row[i][board[i][j]-'0'] = true;
                col[j][board[i][j]-'0'] = true;
                box[(i/3)*3+j/3][board[i][j]-'0'] = true;
            }
        }

        return true;
    }
};