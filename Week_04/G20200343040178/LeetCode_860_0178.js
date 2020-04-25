/*
 * @Author: mingxing.huang
 * @Date: 2020-04-03 10:18:48
 */
/**
 * 860. 柠檬水找零
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
  // 思路：用一个hashmap保存当前的零钱，当需要找零钱时，优先从大面额开始匹配
  let dict = { 5: 0, 10: 0, 20: 0 };
  for (let val of bills) {
    if (val === 5) {
      dict[5]++;
    } else if (val === 10) {
      if (dict[5] > 0) {
        dict[5]--;
        dict[10]++;
      } else {
        return false;
      }
    } else if (val === 20) {
      if (dict[10] > 0 && dict[5] > 0) {
        dict[5]--;
        dict[10]--;
        dict[20]++;
      } else if (dict[5] >= 3) {
        dict[5] -= 3;
        dict[20]++;
      } else {
        return false;
      }
    }
  }
  return true;
};
