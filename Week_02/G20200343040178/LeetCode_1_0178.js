/*
 * @Author: mingxing.huang
 * @Date: 2020-03-20 14:53:51
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let hashMap = {};
  for (let i = 0; i < nums.length; i++) {
    if (hashMap[nums[i]] !== undefined) {
      return [hashMap[nums[i]], i];
    }
    hashMap[target - nums[i]] = i;
  }
};
