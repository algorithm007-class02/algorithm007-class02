class Solution {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int[] dp = new int[grid[0].length];

        for (int rows = grid.length - 1; rows >= 0; rows--) {
            for (int cols = grid[0].length - 1; cols >= 0; cols--) {
                if (cols == grid[0].length - 1 && rows != grid.length - 1) {
                    dp[cols] = grid[rows][cols] + dp[cols];
                } else if (cols != grid[0].length - 1 && rows == grid.length - 1) {
                    dp[cols] = grid[rows][cols] + dp[cols + 1];
                } else if (cols != grid[0].length - 1 && rows != grid.length - 1) {
                    dp[cols] = grid[rows][cols] + Math.min(dp[cols], dp[cols + 1]);
                } else {
                    dp[cols] = grid[rows][cols];
                }
            }
        }
        return dp[0];
    }

}