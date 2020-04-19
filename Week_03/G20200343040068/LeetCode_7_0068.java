    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            help1(result, new ArrayList<Integer>(), 1, n, k);
            return result;
        }

        private void help1(List<List<Integer>> result, List<Integer> select, int start, int n, int k) {
            if (k == 0) {
                result.add(new ArrayList<>(select));
                return;
            }
            for (int i = start; i <= (n - k + 1); i++) {
                select.add(i);
                help1(result, select, i + 1, n, k - 1);
                select.remove(select.size() - 1);
            }
        }
    }