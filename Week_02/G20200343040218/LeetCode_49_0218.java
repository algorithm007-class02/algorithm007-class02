class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String s: strs) {
            char[] s1 = s.toCharArray();
            Arrays.sort(s1);
            String sortedS = new String(s1);
            groupMap.putIfAbsent(sortedS, new ArrayList<String>());
            groupMap.get(sortedS).add(s);
        }
        return new ArrayList<List<String>>(groupMap.values());
    }
}