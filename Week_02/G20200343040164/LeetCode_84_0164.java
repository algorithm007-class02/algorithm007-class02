//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for ( int i = 0 ; i < heights.length ; i++ ) {
                while ( stack.peek() != -1 && heights[stack.peek()] >= heights[i] ) {
                    int area = heights[stack.pop()] * ( i - stack.peek() - 1 );
                    maxArea = Math.max(area,maxArea);
                }
                stack.push(i);
        }
        while ( stack.peek() != -1 ) {
            int area = heights[stack.pop()] * (heights.length - stack.peek() - 1);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
