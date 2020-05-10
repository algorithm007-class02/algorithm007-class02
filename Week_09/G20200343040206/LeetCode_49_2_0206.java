
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
class LeetCode_49_2_0206 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null){
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String anagramSort = anagramsSort(str);
            if (map.get(anagramSort) == null) {
                map.put(anagramSort, new ArrayList<>());
            }
            map.get(anagramSort).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String anagramsSort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
