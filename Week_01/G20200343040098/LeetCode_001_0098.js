https://leetcode-cn.com/problems/two-sum/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
/**
 * 1.暴力解法 
 * 通过两层循环来计算
 * 时间复杂度：O(n^2)
 */
var twoSum1 = function(nums, target) {
    for(var i = 0; i < nums.length - 1; i++) {
        for(var j = i+1; j < nums.length; j ++) {
            if(nums[i]+nums[j] == target) {
                return [i, j];
            }
        }
    }
};

/**
 *2.哈希表法
 * 两次循环，第一次将数组导入到哈希表
 * 第二次遍历数组，查找哈希表是否有对应的值
 * 时间复杂度:O(n)
 */
var twoSum2 = function(nums, target) {
    let map = {}; // js对象(基于哈希表)
     //将数组导入到哈希表
    for(let i=0;i<nums.length;i++) {
        map[nums[i]] = i;
    }
    for(let i=0;i<nums.length;i++) {
        const complement = target - nums[i];
        // 数据存在于哈希表且数据索引不与当前索引值相同
        // hasOwnProperty只判断自身属性(不需要原型链属性)
        if(map.hasOwnProperty(complement) && map[complement] !== i) { 
            return [i,map[complement]]; //输出当前索引和哈希表对应索引
        }
    }
};

/**
 *3.哈希表法
 * 一次循环，第一次将数组导入到哈希表
 * 第二次遍历数组，查找哈希表是否有对应的值
 * 时间复杂度:O(n^2)
 */
var twoSum3 = function(nums, target) {
    let map = {}; // js对象(基于哈希表)
    for(let i=0;i<nums.length;i++) {
        const complement = target - nums[i];
        // 数据存在于哈希表且数据索引不与当前索引值相同
        if(map.hasOwnProperty(complement) && map[complement] !== i) { 
            return [i,map[complement]]; //输出当前索引和哈希表对应索引
        }
        map[nums[i]] = i;
    }
};