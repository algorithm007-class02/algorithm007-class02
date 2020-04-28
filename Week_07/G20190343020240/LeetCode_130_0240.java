class Solution {
    private char[][] board;
    public void solve(char[][] board) {
        this.board = board;

        if(board == null || board.length == 0) return;

        for(int i = 0;i < board.length;i++){
            if(board[i][0] == 'O')
                dfs(i,0);
            if(board[i][board[0].length - 1] == 'O')
                dfs(i,board[0].length - 1);
        }
        for(int i = 0;i < board[0].length;i++){
            if(board[0][i] == 'O') dfs(0,i);
            if(board[board.length - 1][i] == 'O') dfs(board.length - 1,i);
        }

        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(this.board[i][j] == 'O')
                    this.board[i][j] = 'X';
                if(this.board[i][j] == '#')
                    this.board[i][j] = 'O';
            }
        }

    }

    //判断与边界O相连接的O
    private void dfs(int i,int j){
        if(i < board.length && i >= 0 && j >= 0 && j < board[0].length && board[i][j] == 'O'){
            board[i][j] = '#';
            dfs(i + 1,j);
            dfs(i - 1,j);
            dfs(i,j + 1);
            dfs(i,j - 1);
        }
    }
}