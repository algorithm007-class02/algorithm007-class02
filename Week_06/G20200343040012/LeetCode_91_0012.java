class Solution {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int res = 0;
        int help = 1;

        if (s.charAt(s.length() - 1) != '0') {
            res = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                help = res;
                res = 0;
                continue;
            }

            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                res = help + res;
                help = res - help;
            } else {
                help = res;
            }
        }
        return res;
    }

}