package com.leetcode.search.binary;

public class L153FindMinInRotatedArray {

    public int findMin(int[] nums) {
        assert nums != null && nums.length > 0;

        int left = 0;
        int right = nums.length - 1;

        // 数组长度为1 或者 数组没有rotate, 最小值就是n[0]
        if (nums.length == 1 || nums[left] < nums[right]) {
            return nums[0];
        }

        // 数组有rotate
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // 画出数轴分类分析
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        throw new IllegalStateException();
    }
}
