
// 130-被围绕的区域

class Solution {
public:
    void solve(vector<vector<char>>& board) {

        if(board.size()<3)
        	return ;

        int m=board.size();
        int n=board[0].size();
        
        for(int i=0;i<m;i++){
            dfs(i,0,board);
            dfs(i,n-1,board);
        }
        for(int i=0;i<n;i++){
            dfs(0,i,board);
            dfs(m-1,i,board);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='*')board[i][j]='O';
            }
        }
        return ;
    }

    void dfs(int x,int y,vector<vector<char>>&board){

        if(x<0 ||
        	y<0||
        	x>=board.size()||
        	y>=board[0].size()||
        	board[x][y]!='O')
        	return ;

        board[x][y]='*';
        dfs(x+1,y,board);
        dfs(x-1,y,board);
        dfs(x,y+1,board);
        dfs(x,y-1,board);
        return ;
    }
};
