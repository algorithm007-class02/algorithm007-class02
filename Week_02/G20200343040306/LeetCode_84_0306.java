import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (39.17%)
 * Likes:    482
 * Dislikes: 0
 * Total Accepted:    33.3K
 * Total Submissions: 84.9K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 
 */

// @lc code=start
class Solution {
    // 暴力解
    // 长方形的面积为长乘以高，此思路是遍历不同的长，去找对应的高。
    // public int largestRectangleArea(int[] heights) {
    //     int maxArea = 0;
    //     for (int i = 0; i < heights.length; i++) {
    //         for (int j = i; j < heights.length; j++) {
    //             int min = Integer.MAX_VALUE;
    //             for (int k = i; k <= j; k++) {
    //                 if (heights[k] < min) {
    //                     min = heights[k];
    //                 }
    //             }
    //             int area = (j - i + 1) * min;
    //             if (area > maxArea) {
    //                 maxArea = area;
    //             }
                
    //         }
    //     }
    //     return maxArea;
    // }

    // 此思路是遍历不同的高，去找对应的长
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> left = new Stack<>();
        left.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (left.peek() != -1 && heights[i] < heights[left.peek()]) {
                maxArea = Math.max(maxArea,heights[left.pop()] * (i - 1 - left.peek()));
            }
            left.push(i);
        }
        while (left.peek() != -1) {
            maxArea = Math.max(maxArea, heights[left.pop()] * (heights.length - 1 - left.peek()));
        }
        return maxArea;
    }
}
// @lc code=end

