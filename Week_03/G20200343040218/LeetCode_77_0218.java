class Solution {

    /**
     * 递归实现
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k < 0) { return res; }
        if (n == k || k == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                tmp.add(i);
            }
            res.add(tmp);
            return res;
        }

        res = combine(n - 1, k - 1);
        for (List<Integer> list : res) {
            list.add(n);
        }
        res.addAll(combine(n - 1, k));
        return res;
    }

    /**
     * 回溯实现
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        build(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void build(List<List<Integer>> res, List<Integer> tmp,
                       int start, int n, int k) {

        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n - (k - tmp.size()) + 1; i++){
            tmp.add(i);
            build(res, tmp, i + 1, n, k);
            tmp.remove(tmp.size() - 1);
        }
    }
}