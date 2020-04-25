class Solution {
    /* group-anagrams 字母异位词分组 */

    /**
     * 暴力解法
     * 时间 O(NKlogK)
     * 空间 O(NK)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }


    /**
     * 按计数分类 用一个hash值，做key，这里只有小写，所以是26位，
     * 时间 O(M*N)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams_1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String w : strs) {
            String key = hash(w);
            if (!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(w);
        }

        return new ArrayList<>(map.values());
    }

    String hash(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) a[c - 'a']++;
        return Arrays.toString(a);
    }
}