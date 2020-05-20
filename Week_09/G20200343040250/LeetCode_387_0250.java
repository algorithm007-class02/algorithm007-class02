class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        char[] chArr = s.toCharArray();
        for (char ch : chArr) {
            Integer chNum = cache.get(ch);
            if (chNum != null) {
                cache.put(ch, chNum + 1);
            } else {
                cache.put(ch, 1);
            }
        }

        int index = -1;
        for (char ch : chArr) {
            index++;
            if (cache.get(ch) == 1) {
                return index;
            }
        }
        return -1;
    }
}