class Solution {
    private int totalRow = 0;
    private int totalCol = 0;

    public int numIslands(char[][] grid) {
        int total = 0;
        if (grid.length == 0 || grid[0].length == 0) return total;
        totalRow = grid.length;
        totalCol =  grid[0].length;
        // 使用DFS,要点在将该节点周围为全为1全部标记为0
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol; j ++) {
                if (grid[i][j] == '1') {
                    total++;
                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == totalRow || col == totalCol || grid[row][col] == '0') return;
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}