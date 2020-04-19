/*
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */

var moveZeroes = function(nums) {
  var j = 0;
  for (var i = 0; i < nums.length; i++) {
    if (nums[i] != 0) {
      if(i!=j) {
        nums[j] = nums[i];
        nums[i] = 0;
      }
      j++;
    }
  }
};
   