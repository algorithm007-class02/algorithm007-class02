import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, 0, n, res, "");
        return res;
    }

    private void helper(Integer left, Integer right, int n, List<String> res, String s) {

        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            helper(left+1, right, n, res, s+'(');
        }
        if (left > right) {
            helper(left, right+1, n, res, s+')');
        }

    }
}