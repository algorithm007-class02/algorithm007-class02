
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_125_0206 {
    public boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }
        String lows = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(lows.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(lows.charAt(right))) {
                right--;
                continue;
            }
            if (lows.charAt(left) == lows.charAt(right)){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
