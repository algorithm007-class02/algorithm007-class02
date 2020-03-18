//字母异位词
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                hash.put(key, list);
            }
        }
        return new ArrayList<List<String>>(hash.values());

    }
}