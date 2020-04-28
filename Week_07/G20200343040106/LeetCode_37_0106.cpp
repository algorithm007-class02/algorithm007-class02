#include<iostream>
#include<vector>


using namespace std;


class Solution {
public:
    vector<vector<bool>> row;
    vector<vector<bool>> col;
    vector<vector<bool>> box;
    bool find;
    void solveSudoku(vector<vector<char>>& board) {
        row = vector<vector<bool>>(9,vector<bool>(10,false));
        col = vector<vector<bool>>(9,vector<bool>(10,false));
        box = vector<vector<bool>>(9,vector<bool>(10,false));
        // initialize 
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(board[i][j]=='.') continue;
                row[i][board[i][j]-'0'] = true;
                col[j][board[i][j]-'0'] = true;
                box[(i/3)*3+j/3][board[i][j]-'0'] = true;
            }
        }
        find = false;
        traceBack(board,0,0);
        return ;
    }

    void traceBack(vector<vector<char>>& board,int i,int j){
        //if(find) return ;
        if(i==9) {
            find = true;
            return ;
        }
        if(j==9) {
            traceBack(board,i+1,0);
            return ;               //这里 return 很必要。
                                   //比如 (0,9)回到这里，就溢出了。
        }
        if(board[i][j]!='.') traceBack(board,i,j+1);
        else{
                for(int num = 1;num <= 9;num++){
                    if(!find&&!row[i][num]&&!col[j][num]&&!box[(i/3)*3+j/3][num]){
                        row[i][num] = true;
                        col[j][num] = true;
                        box[(i/3)*3+j/3][num] = true;
                        board[i][j] = num+'0';
                        traceBack(board,i,j+1);
                        if(!find){
                            board[i][j] = '.';
                            row[i][num] = false;
                            col[j][num] = false;
                            box[(i/3)*3+j/3][num] = false;
                        }
                    }
                }
            }
        return ;
    }
};
int main(){
    vector<vector<char>> sudoku4 = 
    { {'5','3','.','.','7','.','.','.','.'},
      {'6','.','.','1','9','5','.','.','.'},
    {'.','9','8','.','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
    {'4','.','.','8','.','3','.','.','1'},
    {'7','.','.','.','2','.','.','.','6'},
    {'.','6','.','.','.','.','2','8','.'},
    {'.','.','.','4','1','9','.','.','5'},
    {'.','.','.','.','8','.','.','7','9'}};
    Solution().solveSudoku(sudoku4);
    return 0;
}