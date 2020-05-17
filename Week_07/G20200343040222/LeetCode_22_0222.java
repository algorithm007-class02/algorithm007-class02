public class LeetCode_22_0222 {
    /**
     * 剪枝
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        recurse(0, 0, n, "", res);
        return res;
    }

    private void recurse(int left, int right, int n, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left >= right && left < n) {
            recurse(left + 1, right, n, s + "(", res);
        }
        if (right < n) {
            recurse(left, right + 1, n, s + ")", res);
        }
     }

    /**
     * DP
     * @param n
     * @return
     */
    public List<String> generateParenthesisRe(int n) {
        if (n == 0) return new ArrayList<>();
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - j - 1);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        current.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(current);
        }

        return dp.get(n);
    }

}