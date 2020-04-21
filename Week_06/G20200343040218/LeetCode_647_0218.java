class Solution {
    public int countSubstrings(String s) {
        // a
        int res = s.length();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            // x...yay...x
            res += countS(ss, i - 1, i + 1);
            // x..yaay...x
            res += countS(ss, i, i + 1);
        }
        return res;
    }

    private int countS(char[] ss, int left, int right) {
        int res = 0;
        // x...yay...x  x..yaay...x
        while (left >=0 && right < ss.length && ss[left] == ss[right]) {
            res++;
            left--;
            right++;
        }
        return res;
    }
}