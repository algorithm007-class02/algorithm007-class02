package week02.g20200343040172;


/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * LeetCode-409 Longest Palindrome
 */

public class LeetCode_409_0172 {
    public static void main(String[] args) {
        String str = "bb";
    }

    /**
     * 统计字符串中每个字符出现的频次
     * @param s
     * @return
     */
    public int longestPalindrome_1(String s) {
        // ASCII总共有128个，A的ASCII码是65，a的ASCII码是97，大小写字母之间的ASCII并不连续
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            //若i为基数，i&2==1，否则为0
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }

    /**
     * 贪心算法
     * @param s
     * @return
     */
    public int longestPalindrome_2(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += (v / 2) * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
