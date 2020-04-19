    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length < 1) return new ArrayList<List<Integer>>();
            List<List<Integer>> result = new ArrayList<>();
            int[] visit = new int[nums.length];
            help2(result, new ArrayList<Integer>(), nums,visit);
            return result;
        }

        private void help2(List<List<Integer>> result,List<Integer> select,int[] nums,int[] visit) {
            if (select.size() == nums.length) {
                result.add(new ArrayList<>(select));
                return;
            }

            for (int i = 0;i < nums.length ; i ++) {
                if (visit[i] == 1) continue;
                select.add(nums[i]);
                visit[i] = 1;
                help2(result, select, nums, visit);
                select.remove(select.size() - 1);
                visit[i] = 0;
            }
        }
    }