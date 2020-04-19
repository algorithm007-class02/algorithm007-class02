class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
          if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        //先进行填充第一层
        obstacleGrid[0][0]=1;
        for(int i = 1; i < m ; i++)
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 1 || obstacleGrid[0][i-1] == 0)?0:1;
        for(int i = 1 ; i < n ; i++)
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1 || obstacleGrid[i-1][0] == 0)?0:1;
        //填充其他层
        for(int i = 1 ; i < n ; i++)
            for(int j = 1 ; j < m ; j++){
                if( obstacleGrid[i][j] != 1 ){
                     obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }else{
                    obstacleGrid[i][j] = 0;
                }
            }
        return obstacleGrid[n-1][m-1];
    

    }
}