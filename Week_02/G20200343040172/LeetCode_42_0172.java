package week02.g20200343040172;

import java.util.Stack;

/**
 * LeetCode-42 Trapping Rain Water
 *
 * @author simon
 */
public class LeetCode_42_0172 {

    /**
     * 使用暴力解法
     *
     * @param height
     * @return
     */
    public int trap_1(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int k = i; k < height.length; k++) {
                maxRight = Math.max(maxRight, height[k]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 使用动态编程
     *
     * @param height
     * @return
     */
    public int trap_2(int[] height) {
        //数组的引用==null，和数组是否为空没有任何关系
        if (height == null | height.length <= 1) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    /**
     * 使用栈
     *
     * @param height
     * @return
     */
    public int trap_3(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty()) {
                    break;
                }
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }

    /**
     * 使用双指针
     *
     * @param height
     * @return
     */
    public int trap_4(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
