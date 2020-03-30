class Solution {
    private List<List<Integer>> res;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        int[] visted = new int[nums.length];
        this.nums = nums;
        recur(visted, new LinkedList<Integer>());
        return res;
    }

    private void recur(int[] visted, LinkedList<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<>(curr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visted[i] == 1) {
                continue;
            }
            visted[i] = 1;
            curr.add(nums[i]);
            recur(visted, curr);
            curr.removeLast();
            visted[i] = 0;
        }
    }
}