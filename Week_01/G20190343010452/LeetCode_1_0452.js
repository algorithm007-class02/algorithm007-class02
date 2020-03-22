/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// 暴力求解 O(n^2)
// var twoSum = function(nums, target) {
//   for(let i = 0; i < nums.length; i++) {
//     for (let j = i + i; j < nums.length; j++) {
//       if (nums[i] + nums[j] === target) {
//         return [i, j]
//       }
//     }
//   }
// };

// 使用一个数组来缓存数据 O(n)，思路难点在于所保存到数据是什么？
// [1, 3, 4, 2, 5] 4
// var twoSum = (nums, target) => {
//   let temp = [];
//   for (let i = 0; i < nums.length; i++) {
//     let diff = target - nums[i];
//     if (temp[diff] !== undefined) {
//       return [temp[diff], i];
//     }
//     temp[nums[i]] = i;
//   }
// }

// 使用 Map 缓存 O(n)
// var twoSum = (nums, target) => {
//   let temp = new Map();
//   for (let i = 0; i < nums.length; i++) {
//     let diff = target - nums[i];
//     if (temp.has(diff)) {
//       return [temp.get(diff), i];
//     }
//     temp.set(nums[i], i);
//   }
// }

// 使用对象缓存元素 O(n)
var twoSum = (nums, target) => {
  let temp = {};
  for(let i = 0; i < nums.length; i++) {
      if (temp[nums[i]] >= 0) {
          return [temp[nums[i]], i];
      }

      temp[target-nums[i]] = i;
  }
}
