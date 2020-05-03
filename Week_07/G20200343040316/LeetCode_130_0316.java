package com.wxs.algorithm1.week07;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-25
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_130_0316 {


    public static void main(String[] args) {

        char[][] board =
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};



        char[][] board1 = {
                {'O','O'},
                {'O','O'}
        };

        LeetCode_130_0316 solve130 = new LeetCode_130_0316();

        solve130.solve(board1);

        System.out.println(board1);
    }


    public void solve(char[][] board) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }

            }

        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }

        }

    }

    private void dfs(char[][] board, int row, int col) {

        if (!isArea(board, row, col)) return;
        board[row][col] = '#';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);

    }


    public boolean isArea(char[][] board, int row, int col) {
        return row >= 0 && row < board.length  && col >= 0 && col < board[0].length && board[row][col] != 'X' &&  board[row][col] != '#';
    }

}
