class Solution200 {
    int[] offsetX = new int[] { -1, 1, 0, 0 };
    int[] offsetY = new int[] { 0, 0, -1, 1 };

    // 深度优先搜索
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int newX = i + offsetX[k];
            int newY = j + offsetY[k];
            if (newX >= 0 && newX <= grid.length - 1 && newY >= 0 && newY <= grid[0].length - 1) {
                // 如果相连的位置是1 先置为0 避免重复计算
                if (grid[newX][newY] == '1') {
                    grid[newX][newY] = '0';
                    dfs(grid, newX, newY);
                }
            }
        }
    }

    // 岛屿的数量
    public int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        if (grid.length <= 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
}