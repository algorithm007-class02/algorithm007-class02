class Solution {
    public boolean isValidSudoku(char[][] board) {
        //1.判断行
        //2.判断列
        //3.判断块
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];

        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] != '.'){
                    //数字
                    int num = board[i][j] - '1';
                    //块的下标
                    int index_box = (i / 3) * 3 + j / 3;
                    if(row[i][num] == 1){
                        return false;
                    } else {
                        row[i][num] = 1;
                    }
                    if(col[j][num] == 1){
                        return false;
                    } else {
                        col[j][num] = 1;
                    }
                    if(block[index_box][num] == 1){
                        return false;
                    } else {
                        block[index_box][num] = 1;
                    }
                }
            }
        }
        return true;
    }
}