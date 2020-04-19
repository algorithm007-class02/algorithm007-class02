class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int prev = 1, curr = 1;

        for (int i = 1; i < s.length(); i++) {
            int temp = curr;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    curr = prev;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                curr = curr + prev;
            }

            prev = temp;
        }
        return curr;
    }
}