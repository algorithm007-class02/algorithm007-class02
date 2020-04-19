package com.wxs.algorithm1.week02;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeeCode_49_0316 {


    public static void main(String[] args) {


        LeeCode_49_0316 groupAnagrams49 = new LeeCode_49_0316();

        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams49.groupAnagrams(str);
        System.out.println(lists);


    }


    /**
     * 时间复杂度 O(nklogK) n是strs的长度， O(klogk) 是对字符串排序
     * 空间复杂度：
     * @param strs
     * @return
     */

    public List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> list = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            byte[] bytes = strs[i].getBytes();

            Arrays.sort(bytes);

            String s = new String(bytes);
            if(map.containsKey(s)){
                 map.get(s).add(strs[i]);
            }else {
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(s,strings);
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            list.add(stringListEntry.getValue());
        }

        return list;

    }



}
