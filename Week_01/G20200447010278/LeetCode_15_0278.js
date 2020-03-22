/*
 * @lc app=leetcode.cn id=15 lang=javascript
 *
 * [15] 三数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// 三指针法
var threeSum = function (nums) {
    nums.sort((a, b) => a - b);
    var result = [];
    for (var i = 0; i < nums.length - 2; i++) {
        let j = i + 1;
        let k = nums.length - 1;
        if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
        if(i > 0 && nums[i] == nums[i-1]) continue;

        while (j < k) {
            var sum = nums[i] + nums[j] + nums[k];
            var result_tmp = [nums[i], nums[j], nums[k]];
            if (sum == 0) {
                result.push(result_tmp);
                while (j<k && nums[j] == nums[j+1]) j++; // 去重
                while (j<k && nums[k] == nums[k-1]) k--; 
                j++;
                k--;
            } else if (sum < 0) {
                j++
            } else {
                k--;
            }
        }

    }
    return result;
}

// 暴力破解法
var threeSum_tmp = function (nums) {
    var result = [];
    var repeatSet = new Set();
    var len = nums.length;
    for (var i = 0; i < len - 2; i++) {
        for (var j = i + 1; j < len - 1; j++) {
            for (var k = j + 1; k < len; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    var tmpResult = [nums[i], nums[j], nums[k]];
                    var tmpSortStr = String(tmpResult.sort());
                    if (!repeatSet.has(tmpSortStr)) {
                        result.push(tmpResult);
                        repeatSet.add(tmpSortStr)
                    }
                }
            }
        }
    }
    return result;
};

// @lc code=end

