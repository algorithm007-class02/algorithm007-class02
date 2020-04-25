/*
 * @Author: mingxing.huang
 * @Date: 2020-04-04 23:18:51
 */
/**
 * 153. 寻找旋转排序数组中的最小值
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
  let left = 0;
  let right = nums.length - 1;
  let res = Infinity;
  while (left <= right) {
    let mid = (left + (right - left) / 2) | 0;
    if (nums[mid] >= nums[left]) {
      // 前半部分升序，最小值在最左边
      res = Math.min(res, nums[left]);
      // 然后看后半部分
      left = mid + 1;
    } else {
      res = Math.min(res, nums[mid]);
      right = mid - 1;
    }
  }
  return res;
};
