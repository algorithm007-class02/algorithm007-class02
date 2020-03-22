package com.yequan.leetcode.array.maxarea_11;

/**
 * //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
 * //ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * //
 * // 说明：你不能倾斜容器，且 n 的值至少为 2。
 * //
 * //
 * //
 * //
 * //
 * // 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：[1,8,6,2,5,4,8,3,7]
 * //输出：49
 *
 * @author : Administrator
 * @date : 2020/3/9
 */
public class MaxArea {


    /**
     * 枚举法:
     * loop每一个可能的高度组合
     *
     * 复杂度:
     * 时间复杂度: O(n²)
     * 空间复杂度: O(1)
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * 双指针法:
     * 核心思想: 从数组两端开始往中间遍历, maxArea = 较小高度 * 位置差
     * 此时移动两端指针改变高度
     * 移动高度较小的: 改变较大的高度不会改变有效高度,而位置差变小了maxArea反而变小
     * 移动高度较小的: 当取数组两端高度时,只有较小的高度改变(往中间移),有效高度才可能变大,才有可能使maxArea变大
     * 得出结论:
     * 当从数组两端取往中间取数时,移动高度较小的,往中间靠,直到两端指针重合
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (null == height || height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
