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

public class LeetCode_69_0316 {


    public static void main(String[] args) {
        LeetCode_69_0316 mySqrt69 = new LeetCode_69_0316();

        int i = mySqrt69.mySqrt1(2147395599);
        System.out.println(i);
    }

    // 平方根  y = x^2 ,x 为正数，单调递增，有上下界
    public int mySqrt(int x) {


        if(x ==0 || x ==1){
            return x;
        }

        long right = x ,left = 1,mid = 1;

        while (left <= right){


            mid = left + (right - left)/2;

            if(mid * mid > x){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }

        return (int) right;

    }


    // 牛顿迭代法
    public int mySqrt1(int x) {

        long r = x;
        while (r * r > x){

            r = (r + x/r)/2;
        }

        return (int)r;

    }


}
