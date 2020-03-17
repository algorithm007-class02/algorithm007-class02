/*
 * @Author: mingxing.huang
 * @Date: 2020-03-13 16:51:55
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  // 方法：旋转3次；
  // 去除多余的旋转，【1,2]，旋转k=1和k=3是同样的效果
  k %= nums.length;
  _rotateArray(0, nums.length - 1);
  _rotateArray(0, k - 1);
  _rotateArray(k, nums.length - 1);

  // 翻转数组从start到end的元素
  function _rotateArray(start, end) {
    let l = start;
    let r = end;
    while (l < r) {
      let temp = nums[r];
      nums[r--] = nums[l];
      nums[l++] = temp;
    }
  }
};
