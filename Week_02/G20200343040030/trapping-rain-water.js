/**
 * 暴力解法
 * 时间复杂度O(n^2) 空间复杂度O(1)
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  let total = 0;
  height.forEach((item, index) => {
    let leftMax = 0,
      rightMax = 0;
    for (var i = 0; i <= index; i++) {
      leftMax = Math.max(height[i], leftMax);
    }
    for (var i = index; i < height.length; i++) {
      rightMax = Math.max(height[i], rightMax);
    }
    total += Math.min(leftMax, rightMax) - item;
  });
  return total;
};

/**
 * 解法2 使用栈
 * 时间复杂度O(n) 空间复杂度 O(n)
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  let stack = [],
    current = 0,
    total = 0;
  while (current < height.length) {
    while (stack.length && height[current] > height[stack[stack.length - 1]]) {
      let top = stack[stack.length - 1];
      stack.pop();
      if (!stack.length) break;
      let width = current - stack[stack.length - 1] - 1;
      let ht =
        Math.min(height[current], height[stack[stack.length - 1]]) -
        height[top];
      total += width * ht;
    }
    stack.push(current++);
  }
  return total;
};
