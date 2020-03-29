// /**
//  * @param {number[]} nums
//  * @param {number} target
//  * @return {number[]}
//  * 暴力破解法，时间复杂度O(2n)
//  */
// const twoSum = function(nums, target) {
//   // 数组长度
//   const len = nums.length;
//   // 如果数组少于2个，直接返回
//   if(len < 2) return [];
//   // 暴力将数组中的所有数据相加比较
//   for (let i=0, j=len; i<j; i+=1){
//     for (let j=i+1; j < len; j+=1) {
//       if (nums[i] + nums[j] === target) {
//         return [i, j]
//       }
//     }
//   }
//   return [];
// };

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * 使用类似map的方式(object)存储数组的下标，target-nums[i]的值在object中，那么这样的值是存在的，返回下标，时间复杂度为O(n)，只需遍历一遍数组
 */
const twoSum = function(nums, target) {
  const len = nums.length;
  // 数组为一个元素的时候，直接返回
  if(len < 2) return [];
  const dict = {};
  for(let i=0; i<len; i+=1){
    const num = nums[i];
    if (dict[target-num] !== undefined){
      return [dict[target-num], i];
    }
    dict[num] = i;
  }
};