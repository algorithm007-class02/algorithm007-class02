//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        int landNums = 0;
        for(int r=0; r<grid.length; r++){
            for (int c=0; c<grid[0].length; c++){
                if (grid[r][c]=='1'){
                    landNums++;
                    dfs(grid,r,c);
                }
            }
        }
        return landNums;
    }

    public void dfs(char[][] g, int row, int col) {
        int gr = g.length;
        int gc = g[0].length;

        if (row<0 || col<0 || row>=gr || col>=gc || g[row][col]=='2' || g[row][col]=='0'){
            return;
        }

        if (g[row][col]=='1'){
            //标记为已遍历过的陆地,当然这里标记为0或者全部标记为1都可
            g[row][col]='2';
        }
        dfs(g, row-1, col);
        dfs(g, row+1, col);
        dfs(g, row, col-1);
        dfs(g, row, col+1);
    }
    /*
     * 耗时2ms（96%），使用内存42.4M（6%）*/
}
//leetcode submit region end(Prohibit modification and deletion)
