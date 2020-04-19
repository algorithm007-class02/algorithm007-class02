/**
 * @param {number[]} height
 * @return {number}
 */

// 暴力求解 O(n^2)
var trap1 = function(height) {
  let result = 0;

  height.forEach((item, index) => {
    let leftMax = 0;
    let rightMax = 0;

    for (let i = 0; i <= index; i++) {
      leftMax = Math.max(height[i], leftMax);
    }

    for (let i = index; i < height.length; i++) {
      rightMax = Math.max(height[i], rightMax);
    }

    result += Math.min(leftMax, rightMax) - item;
  });

  return result;
};

// 双指针 O(n)
var trap2 = function (height) {
  let left = 0;
  let right = height.length - 1;
  let leftMax = 0;
  let rightMax = 0;
  let result = 0;

  while (left < right) {
    if (height[left] < height[right]) {
      if (height[left] < leftMax) {
        result += leftMax - height[left];
      } else {
        leftMax = height[left];
      }

      left++;
    } else {
      if (height[right] < rightMax) {
        result += rightMax - height[right];
      } else {
        rightMax = height[right];
      }

      right--;
    }
  }

  return result;
}

// 栈 O(n)
var trap3 = function (height) {
  let i = 0;
  let result = 0;
  const stack = [];

  while (i < height.length) {
    while (stack.length !== 0 && height[i] > height[stack[stack.length - 1]]) {
      const top = stack[stack.length - 1];
      stack.pop();

      if (stack.length === 0) break;

      const distance = i - stack[stack.length - 1] - 1;
      const boundHeight = Math.min(height[i], height[stack[stack.length - 1]]) - height[top];
      result += distance * boundHeight;
    }

    stack.push(i);
    i++;
  }

  return result;
}