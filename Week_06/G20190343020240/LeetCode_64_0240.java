class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                //第一个
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    //第一行，与前一个数字相加
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if(j == 0){
                    //第一列，与上一个数字相加
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else{
                    //比较前一个与上一个，选取最小值与当前值相加放入当前数组
                    grid[i][j] = Math.min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}