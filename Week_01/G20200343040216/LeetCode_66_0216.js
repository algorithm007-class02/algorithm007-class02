/*
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 */

var plusOne = function(digits) {
  for (let i = digits.length; i > 0; i--) {
    digits[i - 1]++;
    if (digits[i - 1] !== 10) {
      return digits;
    } else {
      digits[i - 1] = 0;
    }
  }
  return [1].concat(Array(digits.length).fill(0));
};
