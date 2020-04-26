package week06.g20200343040172;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3_0172 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    /**
     * 采用滑动窗口的解法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
                //i = map.get(s.charAt(j));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    /**
     * 这是我的错误解法，考虑问题不全面
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_wrong(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longestLength = 1, currenLength = 1;
        String currentStr = s.charAt(0) + "";
        for (int i = 1; i < s.length(); ++i) {
            String temp = s.charAt(i) + "";
            if (!currentStr.contains(temp)) {
                currenLength++;
                currentStr += temp;
            } else {
                // 当前字符存在于currentStr中，不应该是从当前字符开始重新构造
                currentStr = temp;
                longestLength = Math.max(longestLength, currenLength);
            }
        }
        return longestLength;
    }
}
