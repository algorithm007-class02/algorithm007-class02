package Week_02.G20200343040246;

import java.util.Stack;
public class LeetCode_42_0246 {
    public static void main(String[] args) {
        Solution solution = new LeetCode_42_0246().new Solution();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(heights));
        System.out.println(solution.trap1(heights));
        System.out.println(solution.trap2(heights));
        System.out.println(solution.trap3(heights));
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. 暴力法：遍历柱子+找到左右两边最大高度
    // 2. 暴力法优化：空间换时间
    // 3. 双指针法
    // 4. 栈
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }

            int min = Math.min(max_left, max_right);
            sum += min > height[i] ? min - height[i] : 0;
        }
        return sum;
    }

    public int trap1(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            sum += min > height[i] ? min - height[i] : 0;
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;

        int maxLeft = 0;
        int maxRight = 0;

        int left = 1;
        int right = height.length - 2;

        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                sum += maxLeft > height[left] ? maxLeft - height[left] : 0;
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                sum += maxRight > height[right] ? maxRight - height[right] : 0;
                right--;
            }
        }
        return sum;
    }

    public int trap3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while(cur < height.length) {
            while (!stack.empty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = cur - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[cur]);
                sum += distance * (min - h);
            }
            stack.push(cur);
            cur++;
        }
        return sum;
    }
}
}