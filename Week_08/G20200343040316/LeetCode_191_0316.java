package com.wxs.algorithm1.week08;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_191_0316 {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("11111111111111111111111111111101",2).toString());
    }

    public int hammingWeight(int n) {

        int count = 0;
        while (n > 0){

            n = n & (n-1);
            count++;

        }
        return count;
    }
}
