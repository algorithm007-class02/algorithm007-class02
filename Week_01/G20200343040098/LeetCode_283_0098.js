/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    // 下一个非0元素的位置
    var lastNotZeroAt = 0;
    for(var i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            nums[lastNotZeroAt] = nums[i];
            // 避免两者相同时被覆盖
            if(i != lastNotZeroAt) {
                nums[i] = 0
            }
            // 指向下一个位置
            lastNotZeroAt++;
        }
    }
};