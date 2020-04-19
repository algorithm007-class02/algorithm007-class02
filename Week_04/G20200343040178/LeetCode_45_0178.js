/*
 * @Author: mingxing.huang
 * @Date: 2020-04-03 17:26:10
 */
/**
 * 45. 跳跃游戏 II
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
  // 思路：查看每个位置能达到的最远位置，计算次数
  let start = 0;
  let end = 1;
  let res = 0;
  while (end < nums.length) {
    let maxPos = 0;
    // start - end构成上一个位置能跳到的区间范围
    for (let i = start; i < end; i++) {
      // 当前位置能跳到的最远位置作为下一个end
      maxPos = Math.max(maxPos, i + nums[i]);
    }
    start = end;
    end = maxPos + 1;
    res++;
  }
  return res;
};
