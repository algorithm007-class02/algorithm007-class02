// 扫雷


class Solution {
public:
    //上，下，左，右，左上，左下，右上，右下
    int dx[8] = {0,1,0,-1,-1,1,-1,1};
    int dy[8] = {1,0,-1,0,-1,-1,1,1};
    int x_len;
    int y_len;
    bool inArea(int x,int y){
        return x>=0&&x<x_len&&y>=0&&y<y_len;
    }
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        x_len = board.size();
        y_len = board[0].size();
        dfs(board,click);
        return board;
    }

    void dfs(vector<vector<char>>& board, vector<int>& click){
        int x = click[0];
        int y = click[1];
        if(board[x][y]=='M'){
            board[x][y]='X';
            return ;
        }
        int bombNum = 0;
        for(int i=0;i<8;i++){
            int tempx = x+dx[i];
            int tempy = y+dy[i];
            if(inArea(tempx,tempy)&&board[tempx][tempy]=='M') bombNum++;
        }
        if(bombNum==0){
            board[x][y] = 'B';
        }else{
            board[x][y] = '0'+bombNum;
            return ;
        }

        for(int i=0;i<8;i++){
            click[0]+=dx[i];
            click[1]+=dy[i];
            if(inArea(click[0],click[1])&&board[click[0]][click[1]]=='E'){
                dfs(board,click);
            }
            click[0]-=dx[i];
            click[1]-=dy[i];
        }
    }
};