class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean [] visited = new boolean[nums.length];
        helperPermute(visited,nums, lists, new ArrayList<Integer>());
        return lists;
    }

    private void helperPermute(boolean [] visited, int[] nums, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                helperPermute(visited,nums, lists, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}