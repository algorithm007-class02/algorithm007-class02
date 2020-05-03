class Solution {
    boolean [][] flag = null;
    int rows = 0;
    int cols = 0;
    char [][] grid = null;
       // 方向数组，它表示了相对于当前位置的 4 个方向的横、纵坐标的偏移量，这是一个常见的技巧,学习！
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count = 0;
        rows = grid.length;
        if(rows <= 0)
            return 0;
        cols = grid[0].length;
        flag = new boolean [rows][cols];
        //进行遍历所有节点
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(!flag[i][j] && grid[i][j] == '1'){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int i , int j){
        //标记访问
        flag[i][j] = true;
        //进行遍历
        for(int k = 0 ; k < 4 ; k++){
            int row = i + directions[k][0];
            int col = j + directions[k][1];
            //是当前节点        未被访问                为陆地
            if(isNull(row,col) && !flag[row][col] && grid[row][col] == '1'){
                dfs(row,col);
            }
        } 
    }
    boolean isNull(int row , int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols)
            return false;
        return true;
    }

}