/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
class Solution {

    /**
     * 解法一：暴力解法
     * 循环遍历数组，每个位置可以存储的水量=两边最大高度的较小值-当前值
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    /**
     * 解法二：在解法一的基础上，对两边最大高度进行存储
     * 循环遍历数组，每个位置可以存储的水量=两边最大高度的较小值-当前值
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) 需要额外空间存储两边最大高度
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int res = 0;
        int[] leftMaxMap = new int[height.length];
        int[] rightMaxMap = new int[height.length];
        leftMaxMap[0] = height[0];
        rightMaxMap[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length - 1; i++) {
            leftMaxMap[i] = Math.max(height[i], leftMaxMap[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            rightMaxMap[i] = Math.max(height[i], rightMaxMap[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(leftMaxMap[i], rightMaxMap[i]) - height[i];
        }
        return res;
    }
}