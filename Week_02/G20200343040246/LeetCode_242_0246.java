package Week_02.G20200343040246;

import java.util.*;

//Java：有效的字母异位词
public class LeetCode_242_0246 {
    public static void main(String[] args) {
        Solution solution = new LeetCode_242_0246
        ().new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram1("anagram", "nagaram"));
        System.out.println(solution.isAnagram1("rat", "car"));
        System.out.println(solution.isAnagram2("anagram", "nagaram"));
        System.out.println(solution.isAnagram2("rat", "car"));
        System.out.println(solution.isAnagram3("anagram", "nagaram"));
        System.out.println(solution.isAnagram3("rat", "car"));
    }
    
    

    class Solution {

        // 1. 字符串排序比较
        // 2. HashMap统计字符
        // 3. 小写字符，采用数组进行优化

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            Arrays.sort(sChars);
            Arrays.sort(tChars);
            return Arrays.equals(sChars, tChars);
        }

        public boolean isAnagram1(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> cnt = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < t.length(); i++) {
                cnt.put(t.charAt(i), cnt.getOrDefault(t.charAt(i), 0) - 1);
                if (cnt.get(t.charAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagram2(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
                cnt[t.charAt(i) - 'a']--;
            }

            for (int count : cnt) {
                if (count < 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagram3(String s, String t) {
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

}
