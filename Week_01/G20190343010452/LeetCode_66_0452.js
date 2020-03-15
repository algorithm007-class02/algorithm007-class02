/**
 * @param {number[]} digits
 * @return {number[]}
 */

 // 时间复杂度O(n)
var plusOne = function(digits) {
  for (let i = digits.length - 1; i >= 0; i--) { // 从最后一个数开始循环
    digits[i] = (digits[i] + 1) % 10; // 算出最后一个数字
    if (digits[i]) return digits; // 如果最后一个数字不是0，直接返回该数组
  }
  digits.unshift(1); // 运行到这里就是999...999的情况，只需首位进位
  return digits;
};
