/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let j = 0;
    if (nums && nums.length) {
        const n = nums.length
        for (let i = 0; i < n; i++) {
            if (nums[i] !== nums[j]) {
                nums[++j] = nums[i]
            }
        }
    }
    return ++j;
  };