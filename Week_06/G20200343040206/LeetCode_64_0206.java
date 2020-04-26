//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_64_0206 {

    /**
     * 一维数组DP:每一个位置记录的是该行的最优解
     * 1.重复
     * 2.状态定义
     * 3.方程
     * f[i,j] = min(f[i+1,j],f[i,j+1]) + a[i,j]
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int width = grid[0].length;
        int[] dp = new int[width];
        dp[0] = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    dp[j] = dp[j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[width - 1];
    }

    /**
     * 递归+缓存
     *
     * 解决直接递归的问题：增加一组缓存，记录当前位置的最小值
     *
     * 缓存的内容：f[i,j] = min(f[i-1,j],f[i,j-1]) + a[i,j]
     *
     */
    public int minPathSum_1(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid.length <= 1 && grid[0].length <= 1) {
            return grid[0][0];
        }

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];

        //int m = grid.length;// row
        //int n = grid[0].length; // column
        //	for(int j = 1; j < n; j++) grid[0][j] = grid[0][j] + grid[0][j-1];
        //	for(int i = 1; i < m; i++) grid[i][0] = grid[i][0] + grid[i-1][0];
        //	for (int i = 1; i < m; i++) {
        //		for (int j = 1; j < n; j++) {
        //				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
        //		}
        //	}
        //	return grid[m - 1][n - 1];


        //int m = grid.length,
        //n = grid[0].length;
        //for(int i = 0; i < m; i++){
        //	for(int j = 0; j < n; j++){
        //	if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
        //	if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
        //	if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        //	}
        //}
        //return grid[m-1][n-1];
    }

    /**
     * 暴力求解：DFS (超时)
     * f[i,j] = min(f[i+1,j],f[i,j+1]) + a[i,j]
     *
     */
    public int minPathSum_2(int[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        return calculate(grid, 0, 0);
    }
    public int calculate(int[][] grid, int row, int col){
        //递归终止条件：最后一排，最后一列
        if (row == grid.length || col == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        //处理当前层逻辑

        //递归
        return grid[row][col] + Math.min(calculate(grid, row + 1, col), calculate(grid, row, col + 1));

        //恢复现场
    }
}
//leetcode submit region end(Prohibit modification and deletion)
