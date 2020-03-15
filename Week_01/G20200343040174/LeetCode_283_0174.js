/**
 * Created by wangqingxia on 2020/3/15.
 */

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes1 = function(nums) {
    let i = 0;
    let start = 0;
    let len = nums.length;
    if (len < 2) {
        return;
    }

    while(i < len){
        if(nums[start] == 0){
            nums.splice(start,1);
            nums[nums.length] = 0;
        }else{
            start++
        }
        i++;

    }
    console.log(nums);
};
var moveZeroes2 = function(nums) {
    var insertZero = 0;
    var n = nums.length;
    for(var i =0 ;i<n;i++){
        if(nums[i] != 0){
            nums[insertZero++] = nums[i]
        }
    }
    while(insertZero < n){
        nums[insertZero++] = 0;
    }
}


//空间局部优化
var moveZeroes3 = function(nums) {
    let res = [];
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== 0) {
            res.push(nums[i]);
        }
    }

    for (let i = 0; i < res.length; i++) {
        nums[i] = res[i];
    }

    for (let i = res.length; i < nums.length; i++) {
        nums[i] = 0;
    }
};

//双指针
var moveZeroes = function(nums) {
    for (let lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
        if (nums[cur] != 0) {
            let temp = nums[cur];
            nums[cur] = nums[lastNonZeroFoundAt];
            nums[lastNonZeroFoundAt] = temp;
            lastNonZeroFoundAt++
        }
    }

    console.log(nums)
};
