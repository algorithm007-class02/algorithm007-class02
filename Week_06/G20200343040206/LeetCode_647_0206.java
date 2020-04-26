//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//
// 示例 1:
//
//
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
//
//
// 示例 2:
//
//
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
//
//
// 注意:
//
//
// 输入的字符串长度不会超过1000。
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_647_0206 {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int center = 0; center <= 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }

    //动态规划
    public int countSubstrings_2(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean[][] flag = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j >=0 ; j--) {
                if (chars[i] == chars[j] && (i - j < 2 || flag[j+1][i-1])) {
                    flag[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
