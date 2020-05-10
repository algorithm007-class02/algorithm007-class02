package com.wxs.algorithm1.week08;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_17_0316 {


    public static void main(String[] args) {
        LeetCode_17_0316 letterCombinations17 = new LeetCode_17_0316();

        List<String> strings = letterCombinations17.letterCombinations("23");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {

        if(digits == null || "".equals(digits)){
            return Arrays.asList();
        }

        Map<Character,String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res = new ArrayList<>();

        // 递归、回溯、dfs ，需要的变量有 存临时结果集 level 、原值、
        this.search("",0,digits,map,res);

        return res;
    }

    private void search(String s, int level, String digits, Map<Character, String> map, List<String> res) {

        if(level == digits.length()){
            res.add(s);
            return;
        }

        String letters = map.get(digits.charAt(level));

        for (int i = 0; i < letters.length(); i++) {
            search(s+letters.charAt(i),level+1,digits,map,res);
        }


    }

}
