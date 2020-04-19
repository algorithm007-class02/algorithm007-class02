package com.wxs.algorithm1.week04;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_33_0316 {


    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};

        LeetCode_33_0316 search33 = new LeetCode_33_0316();

        int search = search33.search(arr, 0);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0 ) {
            return -1;
        }


        int high = nums.length - 1;
        int low = 0;

        int mid;

        while (low <= high) {

            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }


            if (nums[low] <= nums[mid]) {


                if (target >= nums[low] && target < nums[mid]) {

                    high = mid - 1;
                } else {

                    low = mid + 1;
                }


            } else {

                if (target > nums[mid] && target <= nums[high]) {

                    low = mid + 1;
                } else {

                    high = mid - 1;

                }


            }


        }


        return -1;


    }
}
