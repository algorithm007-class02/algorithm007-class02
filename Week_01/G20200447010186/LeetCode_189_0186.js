/**
 * 旋转数组
 * 仔细观察：向右移动的步数k，刚好是等于删除末尾的k个元素，然后把删除的按原有顺序放在头部
 */

// 无需分开判断k的情况 O(n)
var rotate = function(nums, k) {
  for (let i = 0; i < k; i++) {
    nums.unshift(nums.pop());
  }
};

// O(1): 在头部插入
var rotate = function(nums, k) {
  if (nums.length === 1 || k === 0) return nums;
  let moves = [];
  // 如果使用截取末尾k个元素，则一定要分开考虑k和数组长度的关系
  if (k < nums.length) {
    //k实际是我需要拿多少个元素去前面
    moves = nums.slice(-k);
  } else if (k === nums.length) {
    return nums;
  } else {
    //k实际是我需要拿多少个元素去前面
    moves = nums.slice(-(k % nums.length));
  }
  // delete first
  nums.splice(nums.length - k);
  // add again
  nums.unshift(...moves);
};
