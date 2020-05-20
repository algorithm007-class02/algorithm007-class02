
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_5_0206 {
    //中心扩散法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0, right = 0;

        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            //定好中心
            left = i-1;
            right = i+1;
            while (left >=0 && s.charAt(left) == s.charAt(i)){
                len++;
                left--;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)){
                len++;
                right++;
            }
            //左右扩散
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            //判断是否更长
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    /**
     * 动态规划
     * 1、重复子结构: 如果一段字符串（i，j）为回文串，则只需要判断（i-1,j+1）是否为回文，
     *                                             只需判断char(i-1)==char(j+1)即可
     * 2、定义状态数组:dp[l][r]，表示（l,r）为回文串
     * 3、动态方程 if(dp[l+1][r-1] && c[l] == c[r]) dp[l][r]=true
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome_2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxStart = 0, maxEnd = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r - l + 1> maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }

        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
