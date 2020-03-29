/**
 * 两数之和
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// 暴力求解
// var twoSum = function(nums, target) {
//     for(i=0;i<nums.length-1;i++){
//         for(j=i+1;j<nums.length;j++){
//             if(nums[j]=== target - nums[i]){
//                return [i,j]
//             }
//         }
//     }
// };

// map 储存，以数组中值为键，下标为值，
const twoSum = function(nums, target) {
  const map = new Map();
  for (let i = 0; i < nums.length; i++) {
    const diff = target - nums[i];
    if (map.has(diff)) {
      return [i, map.get(diff)];
      //   return [map.get(diff), i]; 为什么只是数组排列顺序不一致，却耗时差别较大
    }
    // set操作一定要放到查找后
    map.set(nums[i], i);
  }
};

// 对象存储
const twoSum = function(nums, target) {
  const map = {};
  for (let i = 0; i < nums.length; i++) {
    // 这里需要注意若存在目标值但下标为0时也会跳出，所以用undefined判断
    if (map[target - nums[i]] !== undefined) {
      return [map[target - nums[i]], i];
    }
    map[nums[i]] = i;
  }
};
