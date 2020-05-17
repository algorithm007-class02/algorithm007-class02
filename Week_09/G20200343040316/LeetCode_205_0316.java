package com.wxs.algorithm1.week09;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_205_0316 {

    public boolean isIsomorphic(String s, String t) {

       if(s.length() != t.length()){
           return false;
       }
       Map<Character,Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.get(sc) == null){
                if(map.containsValue(tc)){
                    return false;
                }
                map.put(sc,tc);
            }else if(map.get(sc) != tc){
                return false;
            }

        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        char[] sm = new char[256];
        char[] tm = new char[256];


        for (int i = 0; i < tArray.length; i++) {

            char sc = sArray[i];
            char tc = tArray[i];

            if(sm[sc] == 0 && tm[tc] == 0){

                sm[sc] = tc;
                tm[tc] = sc;

            }else {
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }


        }

        return true;
    }
}
