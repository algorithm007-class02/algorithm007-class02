/*
 * @Author: mingxing.huang
 * @Date: 2020-04-03 17:38:29
 */
/**
 * 33. 搜索旋转排序数组
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  let l = 0;
  let r = nums.length - 1;
  while (l <= r) {
    let m = ((l + r) / 2) | 0;
    if (nums[m] === target) {
      return m;
    }
    if (nums[m] >= nums[l]) {
      // 前半部分升序
      if (target >= nums[l] && target < nums[m]) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    } else {
      if (target > nums[m] && target <= nums[r]) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
  }
  return -1;
};
