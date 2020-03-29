/**
 * Created by wangqingxia on 2020/3/15.
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */


var rotate = function(nums, k) {
    if (nums.length < 2 || k === 0) {
        return;
    }
    for(let i = 0 ; i < k; i++) {
        nums.unshift(nums.pop());
    }

    //nums.splice(0, 0, ...nums.splice(nums.length - k));
};

var rotate2 = function(nums, k) {
    if (nums.length < 2 || k === 0) {
        return;
    }
    //nums.splice(0, 0, ...nums.splice(nums.length - k));
};

var rotate3 = function(nums, k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
};

function reverse(nums, l, r) {
    while (l < r) {
        let temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
    }
}

// TODO:环状

