/*
 * @Author: mingxing.huang
 * @Date: 2020-03-20 14:56:37
 */
/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  // // 暴力法：求出每个柱子能接到的雨水，遍历每个柱子的左右最大高度(左右两边不考虑，肯定不能接雨水)
  // let total = 0;
  // for (let i = 1; i < height.length - 1; i++) {
  //   let left = i - 1;
  //   let right = i + 1;
  //   let leftMaxHeight = 0;
  //   let rightMaxHeight = 0;
  //   while (left >= 0) {
  //     if (height[left] > leftMaxHeight) {
  //       // 找到了左边的最大高度
  //       leftMaxHeight = height[left];
  //     }
  //     left--;
  //   }
  //   while (right < height.length) {
  //     if (height[right] > rightMaxHeight) {
  //       // 找到了右边最大高度
  //       rightMaxHeight = height[right];
  //     }
  //     right++;
  //   }
  //   let min = Math.min(leftMaxHeight, rightMaxHeight);
  //   if (min > height[i]) {
  //     // 该柱子可以接到雨水
  //     total += min - height[i];
  //   }
  // }
  // return total;

  // // 栈
  // let total = 0;
  // // 用栈来保存元素位置
  // let stack = [];
  // for (let i = 0; i < height.length; i++) {
  //   // stack第一个元素始终保持最高的柱子
  //   while (stack.length > 0 && height[i] > height[peek(stack, 1)]) {
  //     let topHeight = height[stack.pop()];
  //     if (stack.length === 0) {
  //       break;
  //     }
  //     let h = Math.min(height[peek(stack, 1)], height[i]) - topHeight;
  //     let w = i - peek(stack, 1) - 1;
  //     total += h * w;
  //   }
  //   stack.push(i);
  // }
  // return total;
  // // 返回栈顶的第i个元素
  // function peek(stack, i) {
  //   return stack[stack.length - i];
  // }

  // 双指针
  let l = 0;
  let r = height.length - 1;
  let maxLeftHeight = 0;
  let maxRightHeight = 0;
  let total = 0;
  while (l < r) {
    // 从左右两边高度较小一方开始处理，因为只有较小一方才有可能接到雨水
    // 如果当前高度大于它这边的最大高度，这个柱子不能接雨水，并更新对应的最大高度，否则计算
    if (height[l] < height[r]) {
      maxLeftHeight < height[l]
        ? (maxLeftHeight = height[l])
        : (total += maxLeftHeight - height[l]);
      l++;
    } else {
      maxRightHeight < height[r]
        ? (maxRightHeight = height[r])
        : (total += maxRightHeight - height[r]);
      r--;
    }
  }
  return total;
};
