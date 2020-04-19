class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helperPermuteUnique(visited, nums, lists, new ArrayList<Integer>());
        return lists;
    }

    private void helperPermuteUnique(boolean[] visited, int[] nums, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helperPermuteUnique(visited, nums, lists, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        boolean[] visited = new boolean[nums.length];
//        helperPermuteUnique(visited, nums, lists, new ArrayList<Integer>());
//        return lists;
//    }
//    private void helperPermuteUnique(boolean[] visited, int[] nums, List<List<Integer>> lists, List<Integer> list) {
//        if (list.size() == nums.length) {
//            if (!lists.contains(list)) {
//                lists.add(new ArrayList<Integer>(list));
//            }
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                list.add(nums[i]);
//                helperPermuteUnique(visited, nums, lists, list);
//                list.remove(list.size() - 1);
//                visited[i] = false;
//            }
//        }
//    }    
}