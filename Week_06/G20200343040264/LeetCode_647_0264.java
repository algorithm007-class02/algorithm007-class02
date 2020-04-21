class Solution {
    public int countSubstrings(String s) {
        int [][] dp = new int [s.length() + 1][s.length() + 1];
        int ans = 0;
        for (int r = 0; r < s.length(); r ++) {
            char rch = s.charAt(r);
            for (int c = 0; c <= r; c ++) {
                char cch = s.charAt(c);
                if (rch == cch && (r - c <= 1 || dp [r][c + 2] != 0)) {
                    dp [r + 1][c + 1] = 1;
                    ans ++;
                }
            }
        }
        return ans;
    }
}