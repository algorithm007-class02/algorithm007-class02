package com.alang.learn;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_42_0034 {
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    static class Solution {
        public int trap(int[] height) {
            int result = 0;
            if (height == null || height.length < 3) return result;
            int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0;
            while (left < right) {
                if (height[left] < height[right]) {//那边小 就往大的那边移动
                    if (height[left] > maxLeft) {
                        maxLeft = height[left];
                    } else {
                        result += maxLeft - height[left];
                    }
                    left++;
                } else {
                    if (height[right] > maxRight) {
                        maxRight = height[right];
                    } else {
                        result += maxRight - height[right];
                    }
                    right--;
                }
            }
            return result;
        }
    }
}
