class Solution {
    //定义二维数组
    char[][] grid;
    public int numIslands(char[][] grid) {
        int sum = 0;
        //遍历数组
        for(int i = 0;i<grid.length;i++){
            for(int j = 0 ;j<grid[0].length;j++){
                //如果该点是岛屿
                if(grid[i][j]=='1'){
                    sum++;
                    dfs(i,j);
                }
            }
        }
        return sum;

    }
    //深度优先遍历与该点连接的所有岛屿点,并且标记为海
    public void dfs(int row,int col){
        grid[row][col]='0';
        //上边
        if(row-1>=0 && isLand(row-1,col)){
            dfs(row-1,col);
        }
        //下面
        if(row+1<=grid.length-1 && isLand(row+1,col)){
            dfs(row+1,col);
        }
        //左边
        if(col-1>=0 && isLand(row,col-1)){
            dfs(row,col-1);
        }
        //右边
        if(col+1<=grid[0].length-1 && isLand(row,col+1)){
            dfs(row,col+1);
        }
    }
    //该点是否为岛屿
    public boolean isLand(int row,int col){
        return grid[row][col]=='1';
    }
}
