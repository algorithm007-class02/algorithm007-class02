//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        fillNums(new ArrayList<Integer>(),nums);
        return result;
    }
    public void fillNums(List<Integer> temp, int[] nums) {
        if ( temp.size() == nums.length ) {
            result.add(temp);
            return;
        }
        for ( int i = 0; i < nums.length; i++ ) {
            List<Integer> tempPrp = new ArrayList<>();
            tempPrp.addAll(temp);
            if ( !tempPrp.contains(nums[i]) ) {
                tempPrp.add(nums[i]);
                fillNums(tempPrp,nums);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
