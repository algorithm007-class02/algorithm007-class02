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

public class LeetCode_242_0316 {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];


        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;

        }

        for (int i : counter) {

            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
