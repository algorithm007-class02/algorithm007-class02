class Solution {

    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    /**
     * hash
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) { return false; }
        Map<Character, Integer> countMap = new HashMap<>();
        for (char i : s.toCharArray()) {
            countMap.putIfAbsent(i, 0);
            countMap.put(i, countMap.get(i)+1);
        }
        for (char i : t.toCharArray()) {
            if (!countMap.containsKey(i)) {
                return false;
            }
            int count = countMap.get(i);
            if (count <= 0) { return false; }
            countMap.put(i, count-1);
        }
        for (char k : countMap.keySet()) {
            if (countMap.get(k) != 0) {
                return false;
            }
        }
        return true;
    }
}