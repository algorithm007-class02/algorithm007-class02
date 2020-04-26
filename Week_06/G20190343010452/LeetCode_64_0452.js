var minPathSum = function (grid) {
  const n = grid.length;
  const m = grid[0].length;

  for (let i = 1; i < n; i++) {
    grid[i][0] += grid[i - 1][0];
  }

  for (let j = 1; j < m; j++) {
    grid[0][j] += grid[0][j - 1];
  }

  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    }
  }

  return grid[n - 1][m - 1];
};