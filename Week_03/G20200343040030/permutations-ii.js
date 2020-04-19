/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  nums.sort((a, b) => a - b);
  let res = [];
  let used = new Array(nums.length);
  function backtrack(path) {
    if (path.length == nums.length) {
      res.push([...path]);
      return;
    }
    for (let i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
      path.push(nums[i]);
      used[i] = true;
      backtrack(path);
      used[i] = false;
      path.pop();
    }
  }
  backtrack([]);
  return res;
};
