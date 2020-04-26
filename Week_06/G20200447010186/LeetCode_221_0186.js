/**
 * 题目：最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */

var maximalSquare = function (matrix) {
  if (matrix.length === 0) return 0;
  const height = matrix.length;
  const width = matrix[0].length;
  const map = [];
  let maxSide = 0;
  for (let i = 0; i < height; i++) map.push(Array(width));
  for (let i = 0; i < height; i++) {
    for (let j = 0; j < width; j++) {
      if (i === 0 || j === 0) {
        map[i][j] = parseInt(matrix[i][j]);
      } else if (matrix[i][j] === "0") {
        map[i][j] = 0;
      } else {
        map[i][j] =
          Math.min(map[i - 1][j - 1], map[i][j - 1], map[i - 1][j]) + 1;
      }
      if (map[i][j] > maxSide) maxSide = map[i][j];
    }
  }
  return maxSide * maxSide;
};
