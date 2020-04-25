package com.wxs.algorithm1;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_88_0316 {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;


        merge1(nums1, m, nums2, n);

    }


    //时间复杂度 : O(n + m)
    //空间复杂度 : O(m)。

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] copy_nums = new int[m];
        System.arraycopy(nums1, 0, copy_nums, 0, m);

        // nums1 nums1copy
        int i = 0;
        int j = 0;

        int k = 0;
        while (i < m && j < n) {
            nums1[k++] = copy_nums[i] < nums2[j] ? copy_nums[i++] : nums2[j++];

        }

        if (i < m) {
            System.arraycopy(copy_nums, i, nums1, i + j, m + n - i - j);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, j + i, m + n - i - j);
        }


    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {


        int i = m - 1;
        int j = n - 1;

        int k = m + n - 1;


        while (i >= 0 && j >= 0) {
          nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i --];
        }

        // 只有j 没有赋值完的情况，需要将sum2 赋值给 nums1
        while (j >= 0){
            nums1[k--] = nums2[k--];
        }

       // System.arraycopy(nums2,0,nums1,0,j + 1);

    }

}
