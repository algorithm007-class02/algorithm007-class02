//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        preorder(nums,0,new ArrayList<Integer>());
        return result;
    }
    public void preorder(int[] nums,int i,ArrayList<Integer> subset) {
        if (i >= nums.length) return;
        subset = new ArrayList<>(subset);
        result.add(subset);
        preorder(nums,i+1,subset);
        subset.add(nums[i]);
        preorder(nums,i+1,subset);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
