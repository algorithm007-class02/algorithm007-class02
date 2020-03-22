/*
 * @Author: mingxing.huang
 * @Date: 2020-03-13 16:51:55
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let map = {};
  for (let i = 0; i < nums.length; i++) {
    if (map[nums[i]] !== undefined) {
      // 如果该值被需要，返回即可
      return [map[nums[i]], i];
    }
    // map保存每个位置上需要的值
    let key = target - nums[i];
    map[key] = i;
  }
};
