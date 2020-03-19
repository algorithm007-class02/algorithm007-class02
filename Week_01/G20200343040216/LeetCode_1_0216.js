/*
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
 */

var twoSum = function(nums, target) {
  const map = new Map();
  const length = nums.length;
  
  for (let i = 0; i < length; i++) {
    const value = nums[i];
    const find = target - value;

    if (map.has(find)) {
      return [map.get(find), i];
    }

    map.set(value, i);
  }

}
   