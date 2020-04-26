class Solution {
    public int longestValidParentheses(String s) {
        s = ")" + s;
        int[] longest = new int[s.length() + 1];

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')' && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] = longest[i - 1] + 2 + longest[i - longest[i - 1] - 2];
                longest[s.length()] = Math.max(longest[i], longest[s.length()]);
            }
        }

        return longest[s.length()];
    }
}