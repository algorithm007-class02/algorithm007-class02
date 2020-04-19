/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @param {number[]} nums
 * @return {number}
 */

var removeDuplicates = function(nums) {
  //j用于储存当前值的上一个值，count表示出现了多少次非重复元素
  let j = nums[0],
    count = 0;
  for (let i = 1, len = nums.length; i < len; i++) {
    if (nums[i] !== nums[i - 1]) {
      // 如果当前不等于上一个值，即出现新人，count➕1
      count++;
      nums[count] = nums[i];
    }
    j = nums[i]; //避免每一次还要去寻找nums[i-1]，花费时间
  }
  return count;
};

// count即为出现非重复元素的次数，即可作为数组长度
var removeDuplicates = function(nums) {
  let count = 0;
  let len = nums.length;
  for (let i = 0; i < len; i++) {
    // 这里注意是求临界的那个下标，如果写成i与i+1相比，则取的临界值会是真正临界的前一位
    if (nums[i] !== nums[i - 1]) {
      console.log(i);
      nums[count] = nums[i];
      count++;
    }
  }
  return count;
};
