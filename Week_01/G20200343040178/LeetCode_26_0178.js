/*
 * @Author: mingxing.huang
 * @Date: 2020-03-13 16:51:13
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  // // 方法一：遍历nums，遇到重复数字就删除，调用删除api，时间复杂度太高，最坏时间复杂度：O(n^2)
  // for (let i = 1; i < nums.length; i++) {
  //     if (nums[i] === nums[i-1]) {
  //         // 删除重复元素
  //         nums.splice(i, 1);
  //         // 重置下标
  //         i--;
  //     }
  // }
  // return nums.length;

  // 方法二：双指针
  // j表示不重复元素的下标
  let j = 1;
  // 因为是比较后一个数和前一个数是否重复，从第二个数开始判断即可
  for (let i = 1; i < nums.length; i++) {
    // 如果和前一个元素不相等，用nums[j]来保存
    if (nums[i] !== nums[i - 1]) {
      nums[j++] = nums[i];
    }
  }
  return j;
};
