/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  if (!matrix.length || !matrix[0].length) return false;
  const rows = matrix.length - 1, cols = matrix[0].length -1;
  let row = 0, col = cols;
  while (row <= rows && col >= 0) {
      if (matrix[row][col] === target) {
          return true;  
      } else if (matrix[row][col] > target) {
          col--;
      } else {
          row++;
      }
  }
  return false;
};