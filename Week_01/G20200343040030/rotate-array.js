/**
 * 时间复杂度O(n*k)
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotateV1 = function(nums, k) {
  k = k % nums.length;
  //每个元素和第0个位置交换，一次循环以后完成右移+1，循环k次
  let j = 0;
  while (j < k) {
    for (let i = 1; i < nums.length; i++) {
      let temp = nums[i];
      nums[i] = nums[0];
      nums[0] = temp;
    }
    j++;
  }
};

/**
 * 空间换时间
 * 时间复杂度O(n) 空间复杂度O(n)
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotateV2 = function(nums, k) {
  let result = new Array(nums.length);
  for (let i = 0; i < nums.length; i++) {
    result[(i + k) % nums.length] = nums[i];
  }

  for (let i = 0; i < nums.length; i++) {
    nums[i] = result[i];
  }
};

/**
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotateV3 = function(nums, k) {
  let n = nums.length;
  k = k % n;
  let count = 0; //移动了多少次
  let start = 0; //从第一个元素开始
  while (count < nums.length) {
    let currv = nums[start]; //当前值放在初始位置
    let current = start;
    do {
      //确定下一个值的位置
      let next = (current + k) % n;
      //把下一个要交换的位置值先保存
      let temp = nums[next];
      //把当前值放在下一个位置
      nums[next] = currv;
      //当前值设为下一个位置
      currv = temp;
      current = next;
      //完成一次放置，离成功近了一步
      count++;
    } while (current != start); //如果饶了一圈回到起点，说明后面会出现重复，start前进一格
    start++;
  }
};
