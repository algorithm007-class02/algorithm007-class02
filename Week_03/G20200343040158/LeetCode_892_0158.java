class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int level = grid[i][j];
                if (level > 0) {
                    area += (level << 2) + 2;
                    area -= i > 0 ? Math.min(level, grid[i-1][j]) << 1 : 0;
                    area -= j > 0 ? Math.min(level, grid[i][j-1]) << 1 : 0;
                } 
            }
        }
        return area;
    }
}