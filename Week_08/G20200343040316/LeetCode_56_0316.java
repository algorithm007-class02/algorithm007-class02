package com.wxs.algorithm1.week08;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_56_0316 {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{8,10},{2,6},{15,18}};

        LeetCode_56_0316 merge56 = new LeetCode_56_0316();

        int[][] merge = merge56.merge(arr);

        System.out.println(merge);
    }


    public int[][] merge(int[][] intervals) {

        // 排序
        Arrays.sort(intervals,(e1,e2)->e1[0] - e2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;

        for (int[] interval : intervals) {

            if(index == -1 || res[index][1] < interval[0]){
                res[++index] = interval;
            }else {
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }

        return Arrays.copyOf(res,index+1);
    }


}
