class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 1 ; i < grid.length ; i++)
            grid[i][0]+=grid[i-1][0];
        for(int i = 1 ; i < grid[0].length ; i++)
            grid[0][i] += grid[0][i-1];
        //int[] dp = new int[grid[0].length];
        for(int i = 1 ; i < grid.length ; i++)
            for(int j = 1 ; j < grid[0].length ; j++){
                grid[i][j]+= Math.min(grid[i][j-1] , grid[i-1][j]);
            }
        return grid[grid.length-1][grid[0].length-1];
    }
}