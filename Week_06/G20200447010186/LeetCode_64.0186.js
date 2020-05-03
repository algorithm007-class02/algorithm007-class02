/**
 * 题目：最小路径和
 * 描述：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。只能向下或者向右走
 */

/**
 * 解法1:分开for循环。先把临界的两种情况走完
 */
var minPathSum = function (grid) {
  // Get the two dimensions of the grid
  const n = grid.length; // row总数
  const m = grid[0].length; //column总数

  // 二维数组grid[a][b] a代表当前所在行，b代表当前所在列

  // just come from top。当左方当前一个值为边界时
  for (let i = 1; i < n; i++) {
    grid[i][0] += grid[i - 1][0];
  }
  // just come from left。当上方当前一个值为边界时
  for (let j = 1; j < m; j++) {
    grid[0][j] += grid[0][j - 1];
  }
  // Start one row and one column in because we've precomputed
  // those above
  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      // 最后右下角的位置只能是由它的上方或者左方走来的
      grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    }
  }

  // Return the distance bottom right corner
  return grid[n - 1][m - 1];
};

/**
 * 解法2:直接1次双重循环遍历2维数组
 */
var minPathSum = function (grid) {
  if (grid.length == 0) return 0;
  const row = grid.length;
  const column = grid[0].length;

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (i == 0 && j == 0) continue;
      if (i == 0) {
        grid[i][j] = grid[i][j] + grid[i][j - 1];
      } else if (j == 0) {
        grid[i][j] = grid[i][j] + grid[i - 1][j];
      } else {
        grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
      }
    }
  }

  return grid[row - 1][column - 1];
};
