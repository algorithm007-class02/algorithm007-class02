class Solution {
    private List<List<Integer>> res;
    private int maxLevel;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        this.n = n;
        this.maxLevel = k;
        recur(1, new LinkedList<Integer>());
        return res;
    }

    private void recur(int first, LinkedList<Integer> curr) {
        if (curr.size() == this.maxLevel) {
            res.add(new LinkedList(curr));
        }

        for (int i = first; i <= n; ++i ) {
            curr.add(i);
            recur(i + 1, curr);
            curr.removeLast();
        }
    }
}