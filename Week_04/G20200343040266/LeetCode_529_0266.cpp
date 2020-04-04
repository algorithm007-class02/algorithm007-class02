class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        int row=click[0],colum=click[1];
        if (board[row][colum]=='M') {board[row][colum]='X';return board;}
        if (board[row][colum]=='B') {return board;}
        if (board[row][colum]-'0'>=1&&board[row][colum]-'0'<=8) {return board;}
        dfs(board,row,colum);
        return board;
    }

    void dfs(vector<vector<char>>& board,int row,int colum) {
        if (board[row][colum]!='E') return;
        
        int count=numBoom(board,row,colum);
        if (count==0) {
            board[row][colum]='B';
            if(row-1>=0) dfs(board,row-1,colum);
            if(row+1<board.size()) dfs(board,row+1,colum);
            if(colum-1>=0) dfs(board,row,colum-1);
            if(colum+1<board[0].size()) dfs(board,row,colum+1);

            if (row-1>=0&&colum-1>=0) dfs(board,row-1,colum-1);
            if (row-1>=0&&colum+1<board[0].size()) dfs(board,row-1,colum+1);
            if (row+1<board.size()&&colum-1>=0) dfs(board,row+1,colum-1);
            if (row+1<board.size()&&colum+1<board[0].size()) dfs(board,row+1,colum+1);
        }
        else if (count>0) {board[row][colum]='0'+count;}

    }

    int numBoom (vector<vector<char>>& board,int row,int colum) {
        int num=0;
        if (row-1>=0&&board[row-1][colum]=='M') num++;
        if (row+1<board.size()&&board[row+1][colum]=='M') num++;
        if (colum-1>=0&&board[row][colum-1]=='M') num++;
        if (colum+1<board[0].size()&&board[row][colum+1]=='M') num++;

        if (row-1>=0&&colum-1>=0&&board[row-1][colum-1]=='M') num++;
        if (row-1>=0&&colum+1<board[0].size()&&board[row-1][colum+1]=='M') num++;
        if (row+1<board.size()&&colum-1>=0&&board[row+1][colum-1]=='M') num++;
        if (row+1<board.size()&&colum+1<board[0].size()&&board[row+1][colum+1]=='M') num++;

        return num;
    }
};