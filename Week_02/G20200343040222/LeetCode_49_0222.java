public class LeetCode_49_0222 {

    /**
     * 概念当且仅当它们的排序字符串相等时，两个字符串是字母异位词
     * 解法1：将每个字符串char排序 作为key放入Map中，如果map中存在则add，如果不存在，新建ArrayList然后add
     * 时间复杂度为O(NlogK) N是数组长度，K为数组的所有字符串的平均长度，空间复杂度为O(NK)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> resultMap = new HashMap<>();
        for (String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList());
            }
            resultMap.get(key).add(s);
        }
        return new ArrayList(resultMap.values());
    }

    /**
     * 解法2：修改解法1中将字符串字符sort变化为计算每个字符串字符的数量作为key保存到map中
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsRe(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> resultMap = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int cNum : count) {
                sb.append(cNum);
                sb.append("X");
            }
            String key = sb.toString();
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList());
            }
            resultMap.get(key).add(s);
        }
        return new ArrayList(resultMap.values());
    }


}