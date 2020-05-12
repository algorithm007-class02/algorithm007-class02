/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
  let result = 0;
  for (let i = 0; i < 32; i++) {
      result |= (((n >> (31 - i)) & 1) << i) >>> 0;
  }
  return result >>> 0;
};