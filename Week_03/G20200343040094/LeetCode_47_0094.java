import java.awt.List;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, List<Integer> tempList, boolean[] used){
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backTracking(res, nums, tempList, used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }
}
// @lc code=end

