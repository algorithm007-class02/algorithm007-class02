package com.leetcode.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出:   [1,2,2,3,5,6]
 */
public class L88MergeSortedArray {
    /**
     * 常规方法，双指针，从前向后，使用一个大小为m+n的临时数组
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = Arrays.copyOfRange(nums1, 0, m + n);
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        while (c1 < m && c2 < n) {
            if (tmp[c1] <= nums2[c2]) {
                nums1[c3] = tmp[c1];
                c1++;
            } else {
                nums1[c3] = nums2[c2];
                c2++;
            }
            c3++;
        }

        while (c1 < m) {
            nums1[c3] = tmp[c1];
            c1++;
            c3++;
        }

        while (c2 < n) {
            nums1[c3] = nums2[c2];
            c2++;
            c3++;
        }
    }

    /**
     * 双指针，从后向前
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int tail = m + n -1;

        while (tail1 >= 0 && tail2 >= 0){
            if (nums1[tail1] >= nums2[tail2]) {
                nums1[tail] = nums1[tail1];
                tail1--;
            } else {
                nums1[tail] = nums2[tail2];
                tail2--;
            }
            tail--;
        }

        if (tail2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, tail2 + 1);
        }
    }
}
