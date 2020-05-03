import java.util.Arrays;

/**
 * 岛屿问题——并查集实现
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] parent = new int[row * col];
        Arrays.fill(parent,-1);
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    //下侧是否陆地
                    if(i < (row - 1) && grid[i + 1][j] == '1'){
                        union(parent,i * col + j, (i + 1) * col + j);
                    }
                    //右侧是否陆地
                    if(j < (col - 1) && grid[i][j + 1] == '1'){
                        union(parent,i * col + j,i * col + j + 1);
                    }
                }else{
                    parent[i * col + j] = -2;
                }
            }
        }
        int count = 0;
        for(int i = 0;i < parent.length;i++){
            if(parent[i] == -1){
                count++;
            }
        }
        return count;
    }
    private void union(int[] parent,int i,int j){
        int xx = find(parent,i);
        int yy = find(parent,j);
        if(xx != yy){
            parent[xx] = yy;
        }
    }

    private int find(int[] parent,int i){
        if(parent[i] == -1){
            return i;
        }
        return find(parent,parent[i]);
    }
}