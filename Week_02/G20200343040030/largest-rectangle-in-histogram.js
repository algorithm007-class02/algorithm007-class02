/**
 * 栈解法  时间复杂度O(n) 空间复杂度O(n)
 * 每个元素入栈 出栈各一次
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
  let maxarea = 0;
  let stack = [-1];
  for (let i = 0; i < heights.length; i++) {
    //如果即将入栈的元素小于栈顶元素， 就把栈顶元素pop 并计算面积，与最大的面积相比较
    while (stack.length > 1 && heights[i] < heights[stack[stack.length - 1]]) {
      maxarea = Math.max(
        maxarea,
        heights[stack.pop()] * (i - stack[stack.length - 1] - 1)
      );
    }
    stack.push(i);
  }

  while (stack.length > 1) {
    maxarea = Math.max(
      maxarea,
      heights[stack.pop()] * (heights.length - stack[stack.length - 1] - 1)
    );
  }

  return maxarea;
};
