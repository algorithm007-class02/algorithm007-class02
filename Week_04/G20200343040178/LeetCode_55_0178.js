/*
 * @Author: mingxing.huang
 * @Date: 2020-04-03 16:17:02
 */
/**
 * 55. 跳跃游戏
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
  //   // 从后往前，判断前一个位置能否跳到后一个位置
  //   let end = nums.length - 1;
  //   for (let i = end - 1; i >= 0; i--) {
  //     if (i + nums[i] >= end) {
  //       end = i;
  //     }
  //   }
  //   return end === 0;

  // 从前往后，判断能跳到的最大位置
  let k = 0;
  for (let i = 0; i < nums.length; i++) {
    if (i > k) return false;
    // 跳跃能到达的位置
    k = Math.max(k, i + nums[i]);
  }
  return true;
};
