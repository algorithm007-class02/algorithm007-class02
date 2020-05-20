package com.wxs.algorithm1.week09;

import java.util.Arrays;
import java.util.Collections;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_151_0316 {


    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }

}
