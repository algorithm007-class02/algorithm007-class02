class Solution {
        public int minPathSum(int[][] grid) {
        int[][] resArr = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (i == 0 && j == 0){
                    resArr[i][j] = grid[i][j];
                }else if (i == 0){
                    resArr[i][j] = grid[i][j] + resArr[i][j-1];
                }else if (j == 0){
                    resArr[i][j] = grid[i][j] + resArr[i -1][j];
                }else
                {
                    resArr[i][j] = grid[i][j] + Math.min(resArr[i -1][j] , resArr[i][j-1]);
                }
            }
        }
        return resArr[grid.length -1][grid[0].length -1];
    }
}