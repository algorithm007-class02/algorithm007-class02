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

public class LeetCode_55_0316 {


    public static void main(String[] args) {
        LeetCode_55_0316 canJump55 = new LeetCode_55_0316();


        int[] a = {2,3,1,1,4};
        boolean b = canJump55.canJump(a);

        System.out.println(b);
    }

    public boolean canJump(int[] nums) {

        if(nums == null){
            return false;
        }

        int maxIndex = nums.length -1 ;

        for (int i = nums.length -1  ; i >= 0; i--) {


            if(nums[i]+i >= maxIndex){

                maxIndex = i;
            }
        }


        return maxIndex == 0;

    }




}
