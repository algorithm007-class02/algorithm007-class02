package com.wxs.algorithm1.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_344_0316 {

    public void reverseString(char[] s) {

        if(s.length == 0){
            return;
        }

        for (int i = 0,j = s.length -1; i < j; i++,j--) {

            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

        }

    }


}
