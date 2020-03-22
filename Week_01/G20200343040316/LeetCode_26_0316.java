package com.wxs.algorithm1;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-14
 * 修改人  ：LeetCode_26_0316
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_26_0316 {


    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 2, 3, 3, 3, 4, 5};
        removeDuplicates4(nums);
        System.out.println(nums);

    }


    // 空间复杂度 O（1） 时间复杂度O(n)
    public static int removeDuplicates1(int[] nums) {

        int j = 1;
        int i = 0;

        while (j < nums.length) {

            if (nums[i] != nums[j]) {

                nums[++i] = nums[j];

            }
            j++;
        }
        return i + 1;

    }


    // 空间复杂度 O（1） 时间复杂度O(n)
    public static int removeDuplicates3(int[] nums) {

       int i = 0;
       int j = 1;

       while (j < nums.length){

           if(nums[i] != nums[j]){
               nums[++i] = nums[j];
           }
           j++;

       }

       return i+1;
    }



    // 空间复杂度 O（1） 时间复杂度O(n)
    public static int removeDuplicates2(int[] nums) {


        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }

        }


        return nums.length - count;
    }


    public static int removeDuplicates4(int[] nums) {
        int i = 0;
        for (int n : nums){
            if (i == 0 || n > nums[i-1]){
                nums[i++] = n;
            }
        }
        return i;
    }

}
