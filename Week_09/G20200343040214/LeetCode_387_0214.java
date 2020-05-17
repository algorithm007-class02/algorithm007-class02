class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char a : s.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int index = 0;
        for (char a : s.toCharArray()) {
            int count = map.getOrDefault(a, 0);
            if (count == 1) {
                return index;
            }
            index += 1;
        }
        return -1;
    }
}