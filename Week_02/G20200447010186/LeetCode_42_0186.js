/**
 * @param {number[]} height
 * @return {number}
 * 题目：接雨水（困难）
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

/**
 * 解法1:遍历每一列，将其能装的单位雨水加起来，即为总和。O(n2)
 * 对每一列，找出左右的最高列。（可直接排除左右边界元素，因为左右列不会有水，否则水会溢出）
 * 然后取左右最高列中较小值，与当前列比较
 * 结果1：较小值 大于 当前列，则当前列会有雨水
 * 结果2：较小值 等于 当前列，则当前列无水
 * 结果3：较小值 小于 当前列，则当前列无水
 */
var trap = function(height) {
  let total = 0; // 单位水总量
  for (let i = 1, len = height.length - 1; i < len; i++) {
    // 开始往左边查找
    let max_left = 0;
    for (let j = i - 1; j >= 0; j--) {
      // 注意这里不是和当前值比较，而是每次和上一次最大值比较
      if (height[j] > max_left) {
        max_left = height[j];
      }
    }
    // 开始往右边查找
    let max_right = 0;
    for (let j = i + 1; j < height.length; j++) {
      // 注意这里不是和当前值比较，而是每次和上一次最大值比较
      if (height[j] > max_right) {
        max_right = height[j];
      }
    }
    const less = Math.min(max_left, max_right);
    // 仅当较小值大于当前列，才会有水
    if (less > height[i]) {
      var water = less - height[i];
      // 仅在此条件下才放进结果
      total += water;
    }
  }
  return total;
};
