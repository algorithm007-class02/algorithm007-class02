/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
  let nums = 0;
  while (n) {
      n = n & (n - 1);
      ++nums;
  }
  return nums;
};