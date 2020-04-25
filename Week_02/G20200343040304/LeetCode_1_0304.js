/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  const map = {};
  for (let i = 0; i < nums.length; i++) {
    map[nums[i]] = i;
  }

  for (let i = 0; i < nums.length; i++) {
    const result = target - nums[i];
    const cacheId = map[result];
    if (cacheId && cacheId !== i) {
      return [i, cacheId]
    }
  }
};