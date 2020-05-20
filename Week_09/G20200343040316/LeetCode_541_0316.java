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

public class LeetCode_541_0316 {


    public static void main(String[] args) {
        LeetCode_541_0316 reverseStr541 = new LeetCode_541_0316();

        reverseStr541.reverseStr("abcdefg",2);
    }

    /**
     * 输入: s = "abcdefg", k = 2
        输出: "bacdfeg"
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {

        int len = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i += 2 * k) {
            int left = i;
            int right = (i+k-1 <len) ? i+k-1 : len -1;
            while (left < right){

                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        return new String(chars);
    }

}
