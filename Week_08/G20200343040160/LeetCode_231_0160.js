/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
  let nums = 0;
  while (n > 0) {
      n = n & (n - 1);
      ++nums;
  }
  return nums === 1;
};