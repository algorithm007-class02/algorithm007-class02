var swap = function (nums, i, j) {
  [nums[i], nums[j]] = [nums[j], nums[i]]
};

var cal = function (nums, first, result) {
  if (nums.length === first) {
    result.push([...nums]);
    return;
  }

  const map = new Map();
  for (let i = first; i < nums.length; i++) {
    if (!map.get(nums[i])) {
      map.set(nums[i], true);
      swap(nums, first, i);
      cal(nums, first + 1, result);
      swap(nums, first, i);
    }
  }
};

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
  if (nums == null)
    return;

  nums.sort((a, b) => a - b);
  const result = [];
  cal(nums, 0, result);
  return result;
};