/*
 * @Author: mingxing.huang
 * @Date: 2020-03-29 19:09:03
 */
/**
 * 多数元素
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  // 对于过半数的多数元素，用相互抵消的方式，剩下不能抵消的数即是答案
  let count = 1;
  let res = nums[0];
  for (let i = 1; i < nums.length; i++) {
    if (count === 0) {
      res = nums[i];
    }
    nums[i] === res ? count++ : count--;
  }
  return res;
};
