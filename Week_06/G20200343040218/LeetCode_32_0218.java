public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] flag = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    flag[i] = (i >= 2 ? flag[i - 2] : 0) + 2;
                } else if (i - flag[i - 1] > 0 && s.charAt(i - flag[i - 1] - 1) == '(') {
                    flag[i] = flag[i - 1]
                            + ((i - flag[i - 1]) >= 2 ? flag[i - flag[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, flag[i]);
            }
        }
        return maxans;
    }
}