/**
 * 时间复杂度O(n), 空间复杂度O(1)
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    digits[i]++;
    digits[i] %= 10;
    if (digits[i] != 0) return digits;
  }

  return [1, ...digits];
};
