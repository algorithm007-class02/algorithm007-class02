/**
 * 2的幂
 */

// 区分n大于0 / 小于0 情况
var isPowerOfTwo = function (n) {
  return n > 0 ? !(n & (n - 1)) : false;
};
