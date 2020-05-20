package com.wxs.algorithm1.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_917_0316 {
    public String reverseOnlyLetters(String S) {

        StringBuilder res = new StringBuilder();

        int j = S.length() -1;

        for (int i = 0; i < S.length(); i++) {

            if(Character.isLetter(S.charAt(i))){
                while (!Character.isLetter(S.charAt(j))){
                    j--;
                }
                res.append(S.charAt(j--));

            }else {
                res.append(S.charAt(i));
            }

        }

        return res.toString();
    }

}
