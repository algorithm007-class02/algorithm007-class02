package Week_08.G20200343040246;

public class LeetCode_242_0246 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'a']--;
            if (cnt[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}