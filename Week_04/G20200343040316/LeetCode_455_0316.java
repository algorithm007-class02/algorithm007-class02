package com.wxs.algorithm1.week04;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_455_0316 {


    public static void main(String[] args) {

        int[] g = {1,2,3}, s =  {1,1};

        LeetCode_455_0316 findContentChildren455 = new LeetCode_455_0316();

        int contentChildren = findContentChildren455.findContentChildren(g, s);

        System.out.println(contentChildren);


    }


    // 贪心算法， 时间复杂度 OlogN
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;

        int counter = 0;
        for (int i = 0; i < g.length; i++) {

            for (; j < s.length; j++) {

                if(g[i] <= s[j]){

                    counter++;
                    j++;
                    break;
                }

            }

        }

        return counter;

    }



}
