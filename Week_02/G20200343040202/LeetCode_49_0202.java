class Solution {
    /**
     * 49. 字母异位词分组
     *
     * @param strs
     * @return 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     *
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        //思路：对数组中每个字符串重新排序，相等的就是字母异位词
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String newStr = String.valueOf(chars);
//            if (map.containsKey(newStr)) {
//                map.get(newStr).add(str);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(newStr, list);
//            }
//        }
//
//        return new ArrayList<>(map.values());
//    }
}