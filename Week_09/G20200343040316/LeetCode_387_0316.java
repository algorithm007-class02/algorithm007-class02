package com.wxs.algorithm1.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_387_0316 {

    public static void main(String[] args) {
       String s = "loveleetcode";

        LeetCode_387_0316 firstUniqChar387 = new LeetCode_387_0316();

        int i = firstUniqChar387.firstUniqChar(s);
        System.out.println(i);
    }

    public int firstUniqChar(String s) {

        if(s.length() == 0){
            return -1;
        }

        int[] charArry = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charArry[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
           if( charArry[s.charAt(i) - 'a'] == 1){
               return i;
           }
        }
        return -1;
    }
}
