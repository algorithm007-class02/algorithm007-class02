import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, List<Integer> tempList, boolean used[]){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            tempList.add(nums[i]);
            used[i] = true;
            backTracking(res, nums, tempList, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
// @lc code=end

