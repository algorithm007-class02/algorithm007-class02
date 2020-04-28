class Solution {

    
    public int minPathSum(int[][] grid) {

        //dp :grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
         for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0) continue;
                //上边界
               else if(i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                //左边界
                else if(j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                //一般
                else grid[i][j] = Math.min(grid[i - 1][j] , grid[i][j - 1]) + grid[i][j];
            }
         }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    
}