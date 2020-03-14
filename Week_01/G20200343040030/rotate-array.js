/**
 * 时间复杂度O(n*k)
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotateV1 = function(nums, k) {
  //每个元素和第0个位置交换，一次循环以后完成右移+1，循环k次
  let j = 0;
  while (j < k) {
    for (let i = 1; i < nums.length; i++) {
      let temp = nums[i];
      nums[i] = nums[0];
      nums[0] = temp;
    }
    j++;
  }
};
