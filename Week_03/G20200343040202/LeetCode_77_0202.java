class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();

        helperCombine(1, n, k, lists, new ArrayList<Integer>());
        return lists;
    }

    private void helperCombine(int begin, int n, int k, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<Integer>(list));
        }
        for (int i = begin; i < n + 1; i++) {
            list.add(i);
            helperCombine(i + 1,n,k,lists,list);
            list.remove(list.size() - 1);
        }
    }
}