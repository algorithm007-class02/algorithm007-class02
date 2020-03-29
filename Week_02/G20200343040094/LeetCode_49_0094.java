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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1.排序分类
        // 2.哈希计数分类
        Map<String, List<String>> map = new HashMap<>();
        for (String w : strs) {
            String key = hash(w);
            if (!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(w);
        }
        return new ArrayList<>(map.values());
    }

    String hash(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) counter[c - 'a']++;
        return Arrays.toString(counter);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
