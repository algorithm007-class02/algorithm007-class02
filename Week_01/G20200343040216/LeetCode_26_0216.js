/*
 * 26. 删除排序数组中的重复项
 * 注意事项： 原地删除， 返回新长度，数组已经排过序了，从小到大
 */

/**
 *
 * @param {Array[int]} nums
 * @returns {int} i
 */
function removeDuplicates(nums) {
  if (nums.length < 2) return 0;

  let i = 0;
  for (let j = 1; j < nums.length; j++) {
    if (nums[j] != nums[i]) {
      i++;
      nums[i] = nums[j];
    }
  }

  return i + 1;
}

// console.log(removeDuplicates([0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4]));
