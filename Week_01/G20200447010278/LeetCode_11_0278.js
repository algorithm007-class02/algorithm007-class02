/*
 * @lc app=leetcode.cn id=11 lang=javascript
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */

//  双循环法
var maxArea_ex = function (height) {
    if (height.length < 2) {
        return false;
    }
    let number = 0;

    height.forEach((item, index) => {
        for (var i = index + 1; i < height.length; i++) {
            number = Math.max(number, (i - index) * Math.min(item, height[i]));
        }
    })

    return number
};

//双指针
var maxArea = function (height) {
    if (height.length < 2) {
        return false;
    }
    let i = 0,
        number = 0,
        j = height.length -1;

    while (i < j) {
        number = Math.max(number, (j - i) * Math.min(height[j], height[i]))

        if (height[i] < height[j]) {
            i++
        } else {
            j--
        }
    }   
    
    return number
}
// @lc code=end

