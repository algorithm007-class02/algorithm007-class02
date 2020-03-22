//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 至少要3根柱子才会积水
        if (height.length < 3) return 0;

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int current = 0; current < height.length; current++) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()] ) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int curHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                int curWidth = current - stack.peek() - 1;
                sum += curHeight * curWidth;
            }
            stack.push(current);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
