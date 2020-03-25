/**
 * @param {number[]} nums
 * @return {number[][]}
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
   注意：答案中不可以包含重复的三元组
 */
var threeSum = function(nums) {
  // 定义一个最终结果数组
  let res = [];
  // 此时直接返回空数组，不能返回错误的源nums
  if (!nums || nums.length < 3) return res;
  // 首先必转换为有序数组
  let sortArr = nums.sort((a, b) => a - b);
  let len = nums.length;
  // 遍历target值，上限为倒数第2个数，因为后面还要留地方存2指针
  for (let k = 0; k < len - 2; k++) {
    if (nums[k] > 0) break;
    if (k > 0 && nums[k] == nums[k - 1]) continue; // 去重
    // 定义双指针初始位置
    let i = k + 1;
    let j = len - 1;

    while (i < j) {
      const sum = nums[i] + nums[j] + nums[k];
      if (sum === 0) {
        res.push([nums[k], nums[i], nums[j]]);
        while (i < j && nums[i] === nums[i + 1]) {
          i++;
        }
        while (i < j && nums[j] === nums[j - 1]) {
          j--;
        }
        i++;
        j--;
      } else if (sum < 0) {
        i++;
      } else if (sum > 0) {
        j--;
      }
    }
  }
  return res;
};
