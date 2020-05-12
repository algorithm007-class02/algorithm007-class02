package com.logic;

import java.util.Arrays;

/**
 * @Auther: welllu
 * @Date: 2020/5/3 09:43
 * @Description:
 */
public class LeeCode_56_0226 {
    public int[][] merge(int[][] intervals) {
        // 区间起始位置排序
        Arrays.sort (intervals, (int[] v1, int[] v2) -> v1[0] > v2[0]);

        int res[][] = new int[intervals.length][2];
        int idx = -1;

        // 遍历区间，结果数组为空或者第一区间起始大于第二区间结尾则不合并；反之合并

        for(int[] interval: intervals) {
            if(idx == -1 || interval[0] > res[idx][1]) {
                res[++ idx] = interval;
            }else{
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }

        return Arrays.copyOf ( res,idx + 1 );

    }
}
