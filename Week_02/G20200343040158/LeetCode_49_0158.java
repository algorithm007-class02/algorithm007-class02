class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str:strs) {
            char [] s = str.toCharArray();
            Arrays.sort(s);
            String find = new String(s);
            if (map.containsKey(find)) {
                List<String> arr = map.get(find);
                arr.add(str);
                map.put(find, arr);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(find, arr);
            }
        }
        return new ArrayList<>(map.values());
    }
}