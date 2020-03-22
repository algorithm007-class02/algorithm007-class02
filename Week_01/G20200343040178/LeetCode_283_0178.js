/*
 * @Author: mingxing.huang
 * @Date: 2020-03-13 16:51:55
 */
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  // 双指针，j标识非零元素下标
  let j = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0 && nums[j] === 0) {
      // 交换
      let temp = nums[j];
      nums[j++] = nums[i];
      nums[i] = temp;
    }
  }
};
