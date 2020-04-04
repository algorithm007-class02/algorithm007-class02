/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  let res = [];
  function backtrack(path) {
    if (path.length == nums.length) {
      res.push([...path]);
      return;
    }
    for (let i = 0; i < nums.length; i++) {
      if (path.indexOf(nums[i]) > -1) continue;
      path.push(nums[i]);
      backtrack(path);
      path.pop();
    }
  }
  backtrack([]);

  return res;
};
