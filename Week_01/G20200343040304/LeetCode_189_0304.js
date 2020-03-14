/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const rotate = function (nums, k) {
  const len = nums.length;
  const reversed = nums.splice(len - k, k);
  nums.splice(0, 0, ...reversed);
};