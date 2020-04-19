/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  if (!matrix || !matrix.length) return false;
  for (var i = matrix.length - 1; i>=0; i--) {
      var last = matrix[i][matrix[i].length - 1];
      var first = matrix[i][0];
      if (target > last) {
          return false;
      }
      if (target < first) {
          continue;
      }
      for (var j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j] === target) return true;
      }
      return false;
  }
  return false;
};