/*
 * @Author: mingxing.huang
 * @Date: 2020-03-13 16:51:55
 */
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  // 方法一：数组转成数字进行加一操作，可能会溢出
  // 方法二：数组从末尾开始，每个数字进行加一操作，满十进一
  for (let i = digits.length - 1; i >= 0; i--) {
    // 加一
    digits[i] += 1;
    // 取模，如果不为0，说明没有满十，返回即可，如果为0，前一位继续加一判断
    digits[i] %= 10;
    if (digits[i] !== 0) {
      return digits;
    }
  }
  // 特殊情况，类似：999，+1，会多出一位
  if (digits[0] === 0) {
    digits.splice(0, 0, 1);
  }
  return digits;
};
