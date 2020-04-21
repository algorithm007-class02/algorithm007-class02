class Solution {
    public int minPathSum(int[][] grid) {
        for(int i =0; i<grid.length;++i){
            for(int j = 0 ; j<grid[0].length;++j){
                if(i==0&&j==0)continue;
                else if(i==0) grid[i][j] = grid[i][j-1]+grid[i][j];
                else if(j==0) grid[i][j] = grid[i-1][j]+grid[i][j];
                else grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}

//使用原有数组所以空间复杂度为O(1),循环所有行列，时间复杂度为O(行*列)
//在每一行的都是当前+上一格的数据
//每一列都是当前+上一格的数据
//对角线的位置取上和左方向的最小值再加上自身
