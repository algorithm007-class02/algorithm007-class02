// /**
//  * @param {number[]} digits
//  * @return {number[]}
//  * 暴力解法: 时间复杂度为O(n), 从数组的最高位开始相加，如果数字是9，数组重新赋值为0，继续在上一个下标数字的判断；
//  * 如果数组头元素是9，那就在头部在推入1，返回结果即可
//  */
// var plusOne = function(digits) {
//   // 数组数字为0的情况直接返回1即可
//   if (digits[0] === 0) {
//     return [1];
//   };
//   // 从数组的高位往前判断如果小于9，就把此位置的数字加1返回数组即可；如果是9，那就赋值为0，继续处理上一个坐标的数字；如果头部数字是9并且需要加1那么就需要在头部插入1，并把此位置的数字变为0
//   for (let i=digits.length-1; i>=0; i-=1) {
//     // 如果i位置的数字是9，直接赋值为0
//     if (digits[i] === 9) {
//       digits[i] = 0;
//       // 如果这个元素是首元素的话，就在数组首位插入一个数字1，否自它的上一个数字加1
//       if (i === 0) {
//         digits.unshift(1);
//       }
//     } else {
//       digits[i] += 1;
//       break;
//     }
//   }
//   return digits;
// };


/**
 * @param {number[]} digits
 * @return {number[]}
 * 时间复杂度为O(n), 写法更加简洁;
 * 1.除了9之外的数字加1，返回数组，2.9的数字变为0，继续处理上一个数字，3.数组中的数字全部处理完成后，如果头部为0,还需要在头部插入一个数字1
 * 
 */
var plusOne = function(digits) {
  // 数组数字为0的情况直接返回1即可
  if (digits[0] === 0) {
    return [1];
  };
  // 
  for (let i=digits.length-1; i>=0; i-=1) {
    digits[i] = (digits[i] + 1) % 10;
    if(digits[i] !== 0) {
      return digits;
    }
  }
  digits.unshift(1);
  return digits;
};