/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const twoSum = function (nums, target) {
  const map = new Map();
  for (let i = 0; i < nums.length; i++) {
    map.set(nums[i], i);
  }
  for (let i = 0; i < nums.length; i++) {
    const other = target - nums[i];
    if (map.get(other) && map.get(other) !== i) {
      return [i, map.get(other)]
    }
  }
  return [];
};