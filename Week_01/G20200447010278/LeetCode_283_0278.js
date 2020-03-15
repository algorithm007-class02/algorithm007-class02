/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes_tmp = function (nums) {
    let zeroNums = 0;
    for (let i = 0; i < nums.length - zeroNums; i++) {
        if (nums[i] == 0) {
            nums.splice(i, 1);
            nums.push(0);
            i--;
            zeroNums++;
        }
    }

    return nums;
};

var moveZeroes = function (nums) {
    let noZeroNums = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            nums[noZeroNums] = nums[i];
            if(i > noZeroNums) nums[i] = 0;
            noZeroNums++;
        }        
    }
}
// @lc code=end

