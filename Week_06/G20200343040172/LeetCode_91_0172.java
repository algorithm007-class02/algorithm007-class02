package week06.g20200343040172;

public class LeetCode_91_0172 {

    public static int numDecodings1(String s) {
        if (s == null || s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, curr = 1;
        for (int i = 1; i < s.length(); ++i) {
            int tmp = curr;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || ((s.charAt(i - 1) == '2') && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }

    public static int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }


    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            return recursion(s, 0);
        }

        //递归的套路，加一个index控制递归的层次
        private int recursion(String s, int start) {
            //递归的第一步，应该是加终止条件，避免死循环。
            if (s.length() == start) {
                return 1;
            }
            //以0位开始的数是不存在的
            if (s.charAt(start) == '0') {
                return 0;
            }
            //递归的递推式应该是如果index的后两位小于等于26，
            // digui(s, start) = digui(s, start+1)+digui(s, start+2)
            // 否则digui(s, start) = digui(s, start+1)
            int ans1 = recursion(s, start + 1);
            int ans2 = 0;
            if (start < s.length() - 1) {
                int ten = (s.charAt(start) - '0') * 10;
                int one = (s.charAt(start + 1) - '0');
                if (ten + one <= 26) {
                    ans2 = recursion(s, start + 2);
                }
            }
            return ans1 + ans2;
        }
    }
}
