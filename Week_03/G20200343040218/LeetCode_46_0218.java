class Solution {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯 实现
     */
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        build(nums, visited, tmp);
        return res;
    }

    private void build(int[] nums, boolean[] visited, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                tmp.add(nums[i]);
                visited[i] = true;
                build(nums, visited, tmp);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            build(res, num);
        }
        return res;
    }

    private void build2(List<List<Integer>> res, int num) {
        int size = res.size();
        for (int index = 0; index < size; index++) {
            List<Integer> list = res.get(index);
            for (int i = 0; i < list.size(); i++) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(i, num);
                res.add(tmp);
            }
            list.add(num);
        }
    }
}