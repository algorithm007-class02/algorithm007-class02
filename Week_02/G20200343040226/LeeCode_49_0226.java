package com.logic;

import java.util.*;

/**
 * @Auther: welllu
 * @Date: 2020/3/22 18:07
 * @Description:
 */
public class LeeCode_49_0226 {

    //  遍历字符串
    //  计算key
    //  插入map，value为list
    //  map value转化为返回值

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<> ();
        for (String str : strs) {
            char[] cChars = str.toCharArray();
            Arrays.sort(cChars);
            String key = String.valueOf(cChars);
            List<String> temp = null;
            if (map.containsKey(key)) {
                temp = map.get(key);
                temp.add(str);
            }else{
                temp = new ArrayList<> ();
                temp.add(str);
                map.put(key, temp);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
