/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  var map = new Map();

  for (let i = 0 ; i < nums.length; i++) {
    map.set(nums[i], i)
  }

  for (let i = 0 ; i < nums.length; i++) {
    let com = target - nums[i];
    if(map.has(com) && map.get(com) !== i) {
      return [i, map.get(com)]
    }
  }
};