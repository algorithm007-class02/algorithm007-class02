/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function (height) {
  if (!height.length) {
    return 0;
  }
  let stack = [];
  let sum = 0;
  for (let i = 0; i < height.length; i++) {
    while (stack.length != 0 && height[stack[stack.length - 1]] < height[i]) {
      let tmp = stack.pop();
      if (!stack.length) {
        break;
      }
      sum += (Math.min(height[i], height[stack[stack.length - 1]]) - height[tmp]) * (i - stack[stack.length - 1] - 1);
    }
    stack.push(i);
  }
  return sum;
};