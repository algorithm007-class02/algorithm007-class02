/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 *      [
 *          ["ate","eat","tea"],
 *          ["nat","tan"],
 *          ["bat"]
 *      ]
 */
class Solution {

    /**
     * 解法一：排序比较
     * 时间复杂度：O(nklogk)
     * 空间复杂度：O(nk)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList(map.values());
    }

    /**
     * 解法二：统计字符个数比较
     * 时间复杂度：O(nk)
     * 空间复杂度：O(nk)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            int[] count = new int[26];
            for (Character c :s.toCharArray()) count[c - 'a']++;
            String
            for(){

            }
            String str = String.valueOf(chars);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList(map.values());
    }
}