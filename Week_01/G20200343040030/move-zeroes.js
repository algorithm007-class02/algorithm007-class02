/**
 * 原始解法
 * 时间复杂度O(n), 空间复杂度O(1)
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroesV1 = function(nums) {
  let j = 0;
  for (let i = 0; i < nums.length; i++) {
    //先把非0排好队
    if (nums[i] != 0) {
      nums[j] = nums[i];
      j++;
    }
  }

  //补足0
  while (j < nums.length) {
    nums[j] = 0;
  }
};

/**
 * 交换法
 * 时间复杂度O(n), 空间复杂度O(1)
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroesV2 = function(nums) {
  let j = 0; //记录可交换的位置
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] != 0) {
      let temp = nums[i];
      nums[i] = 0;
      nums[j] = temp;
      j++;
    }
  }
};
