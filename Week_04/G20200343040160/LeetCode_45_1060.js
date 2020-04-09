/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
  const len = nums.length- 1;
  let ans = 0, edge = 0, max = 0;
  for (let i = 0; i < len; i++) {
      max = Math.max(max, nums[i] + i);
      if (i === edge) {
          edge = max;
          ans++;
      }
  }
  return ans;
};