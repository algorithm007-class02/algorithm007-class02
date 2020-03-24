class Solution409 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        int[] counts = new int[58];
        int len = 0;
        for (char c : s.toCharArray()) {
            counts[c - 'A'] += 1;
        }
        for (int c : counts) {
            len += (c / 2) * 2;
            if (c % 2 == 1 && len % 2 == 0) {
                len += 1;
            }
        }
        return len;
    }

    public int longestPalindrome2(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        boolean odd = false;
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, count + 1);
            }
        }
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            int count = map.get(key);
            if (count % 2 != 0) {
                len += count - 1;
                if (!odd) {
                    len += 1;
                    odd = true;
                }
            } else {
                len += count;
            }
        }
        return len;
    }
}