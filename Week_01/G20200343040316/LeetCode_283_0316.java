package com.wxs.algorithm1;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-11
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_283_0316 {


    public static void main(String[] args) {


        int[] arr = {1, 0, 0, 3, 12};

        moveZeroes3(arr);

        System.out.println(arr);

    }


    public static void moveZeroes(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {

                int z = nums[i];
                nums[i] = nums[j];
                nums[j] = z;
                j++;
            }

        }


    }

    public static void moveZeroes1(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }

        }


    }


    public static void moveZeroes2(int[] nums) {

        int j = 0;
        for (int num : nums) {
            if(num != 0){
                nums[j++] = num;
            }
        }

        while (j < nums.length){

            nums[j++] = 0;
        }

    }





    public static void moveZeroes3(int[] nums) {


        if(nums == null || nums.length < 1){
            return;
        }

        // 遇到0 ，记录坐标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j ++ ;
            }


        }


    }


























}
