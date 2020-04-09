class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>(); 
        DFS(0, 0, n, res, "");
        return res;
    }

    private void DFS(int left, int right, int n, List<String> res, String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            DFS(left+1, right, n, res, s+'(');
        }

        if (left > right) {
            DFS(left, right+1, n, res, s+')');
        }
    }
}