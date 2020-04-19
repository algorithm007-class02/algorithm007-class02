
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_49_0206 {
    //1.暴力循环O（n^2）
    //2.map，key为排序字符串，value为不同的异位词；一次循环搞定，O（N*KlogK）

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sortS = sortStr(s);
            if (!map.containsKey(sortS)) {
                map.put(sortS, new ArrayList<>());
            }
            map.get(sortS).add(s);
        }

        return new ArrayList(map.values());
    }

    private String sortStr(String s) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
    }

    //most vote学到的解法
    //首先初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。
    //这样的话，"abb" 就映射到了 "1#2#0#0#0"。
    //"cdc" 就映射到了 "0#0#2#1#0"。
    //"dcc" 就映射到了 "0#0#2#1#0"。
    public List<List<String>> groupAnagrams_2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sortS = transformStr(s);
            if (!map.containsKey(sortS)) {
                map.put(sortS, new ArrayList<>());
            }
            map.get(sortS).add(s);
        }

        return new ArrayList(map.values());
    }

    private String transformStr(String s) {
        String result = "";
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-'a']++;
        }
        for (int j = 0; j < num.length; j++) {
            result = result + num[j] + '#';
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        LeetCode_49_0206 source = new LeetCode_49_0206();
        source.groupAnagrams_2(str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)