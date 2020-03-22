package com.wxs.algorithm1;

/**
 * 类描述  ：旋转数组
 * 创建人  : 吴绪森
 * 创建时间：2020-03-14
 * 修改人  ：
 * 修改时间：LeetCode_26_0316
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_189_0316 {

    // 时间复杂度 O(N*K) 空间复杂度O(1)
    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {

            int last = nums[nums.length - 1];
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = last;
                last = tmp;
            }

        }
    }


    public void rotate1(int[] nums, int k) {


        int[] a = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }


        for (int i = 0; i < a.length; i++) {
            nums[i] = a[i];
        }


    }



    // 时间复杂度O(n) ,空间复杂度O(1)
    public void rotate2(int[] nums, int k) {

        k %= nums.length;// 尾部移动到头的位置
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);


    }

    public void reverse(int[] nums, int start, int end) {


        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }


    }


}
