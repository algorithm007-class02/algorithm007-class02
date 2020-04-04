/*
 * @Author: mingxing.huang
 * @Date: 2020-03-29 19:15:41
 */
/**
 * 电话号码的字母组合
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  let hashMap = {
    "2": "abc",
    "3": "def",
    "4": "ghi",
    "5": "jkl",
    "6": "mno",
    "7": "pqrs",
    "8": "tuv",
    "9": "wxyz"
  };
  if (!digits) return [];
  let res = [];
  fn(0, "", digits.length);
  return res;

  function fn(i, s, max) {
    // 终止条件
    if (i === max) {
      res.push(s);
      return;
    }
    // 本层逻辑
    let currStr = hashMap[digits[i]];
    for (let c of currStr) {
      // 进入下一层
      fn(i + 1, s + c, max);
    }
  }
};
