/**
 * 暴力解法
 * 时间复杂度O(n^2), 空间复杂度O(1)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (target == nums[i] + nums[j]) return [i, j];
    }
  }
};

/**
 * 哈希解法
 * 时间复杂度O(n), 空间复杂度O(n)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSumWithHash = function(nums, target) {
  const map = new Map();
  for (let i = 0; i < nums.length; i++) {
    map.set(nums[i], i);
  }

  for (let j = 0; j < nums.length; j++) {
    let index = map.get(target - nums[j]);
    if (index && index != j) return [j, index];
  }

  return [];
};
