package level2;

public class Solution647 {
    int ans = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            count(i, i, s);// 奇数长度 中心为 i
            count(i, i + 1, s);// 偶数长度 中心为 i i+1
        }
        return ans;
    }

    private void count(int start, int end, String s) {
        while (start >= 0 && end <= s.length() && s.charAt(start) == s.charAt(end)) {
            start -= 1;
            end += 1;
            ans += 1;
        }
    }

    public int countSubstrings2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // 子串的长度为 1 2 3；n
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res += 1;
                    }

                }
            }
        }
        return res;
    }

    public int countSubstrings3(String s) {
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[s.length()];
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {
                dp[j] = chars[i] == chars[j] && (j - i <= 2 || dp[j - 1]);
                if (dp[j])
                    res++;
            }
        }
        return res;
    }

}
