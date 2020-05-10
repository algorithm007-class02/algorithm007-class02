
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1:
//
//
//输入: "aba"
//输出: True
//
//
// 示例 2:
//
//
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
//
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_680_0206 {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        //双指针，删除字符，记录左右
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
