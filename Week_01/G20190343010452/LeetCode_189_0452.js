// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

// O(n)
// var rotate = function (nums, k) {
//   while(k > 0) {
//     nums.unshift(nums.pop());
//     k--;
//   }
// };

// O(1)
var rotate = function (nums, k) {
  nums.unshift(...nums.splice(nums.length - k));
}