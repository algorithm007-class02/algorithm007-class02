/**
 * 空间复杂度O(n) 时间复杂度O(1)
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  if (nums.length == 0) return 0;
  let j = 0; //上一个交换的位置
  for (let i = 0; i < nums.length; i++) {
    //如果出现新的数字，就和上一个交换的位置的下一个交换
    //利用了排序好的特性
    if (nums[i] != nums[j]) {
      nums[++j] = nums[i];
    }
  }
  return ++j;
};
