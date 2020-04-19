/**
 * Created by wangqingxia on 2020/3/15.
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    //temp = target - [i]，i++，find temp
    let i = 0;
    let a = 0;
    let b = -1;
    while(i < nums.length){
        let temp = target - nums[i];
        b = nums.findIndex( (elm,x) => {
                if(x !== i){
            return elm === temp
        }
    });
        if(b !== -1){
            a = i;
            i += nums.length;
        }
        i++;
    }
    return [a,b];

};
var twoSum2 = function(nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let dif = target-nums[i]
        if (map.has(dif)) {
            return [map.get(dif), i]
        }
        map.set(nums[i], i);
    }
};
var twoSum3 = function(nums, target) {
    let box = {};
    for (let i = 0; i < nums.length; i++) {
        let num = nums[i];
        if (num in box) {
            return [box[num], i];
        } else {
            box[target - num] = i;
        }
    }
};
var twoSum4 = function(nums, target) {
    let elemenes = [];
    for (let i = 0; i < nums.length; i++) {
        let num = nums[i];
        // target - num 还差多少（才可以使两数相加=target）
        let index = elemenes[target - num];
        if (index !== undefined) {
            return [index, i];
        }
        elemenes[num] = i;
    }
};
