class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int dp0 = 1;
        int dp1 = 1;
        int dp2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp2 += dp1;
            }

            int tmp = charArrayToInt(s, i - 1, i + 1);
            if (tmp >= 10 && tmp <= 26) {
                dp2 += dp0;
            }
            dp0 = dp1;
            dp1 = dp2;
            dp2 = 0;
        }

        return dp1;
    }

    int charArrayToInt(String data, int start, int end) {
        if (start < 0) {
            start = 0;
        }
        
        int result = 0;
        for (int i = start; i < end; i++) {
            int digit = (int) data.charAt(i) - (int) '0';
            assert (digit >= 0 && digit <= 9);
            result *= 10;
            result += digit;
        }
        return result;
    }
}
