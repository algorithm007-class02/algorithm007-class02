/*
 * @Author: mingxing.huang
 * @Date: 2020-04-02 18:34:09
 */
/**
 * 200.岛屿数量
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  let res = 0;
  let dirs = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
  ];
  const rowLen = grid.length;
  if (rowLen === 0) {
    return [];
  }
  const colLen = grid[0].length;
  for (let i = 0; i < rowLen; i++) {
    for (let j = 0; j < colLen; j++) {
      if (grid[i][j] === "1") {
        res++;
        dfs(i, j);
      }
    }
  }
  return res;

  // 深度优先
  function dfs(i, j) {
    if (i < 0 || i >= rowLen || j < 0 || j >= colLen || grid[i][j] === "0")
      return;
    grid[i][j] = "0";
    for (let dir of dirs) {
      dfs(i + dir[0], j + dir[j]);
    }
  }
};
