class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return results;
        }
        combine(1,n,k,new ArrayList<Integer>());
        return results;
    }

    private void combine(int start, int n, int k, List<Integer> result){
        if (result.size() == k) {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        if (start > n) {
            return;
        }

        combine(start + 1, n, k, result);
        result.add(start);
        combine(start + 1, n, k, result);

        result.remove(result.size()-1);
    }
}