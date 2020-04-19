//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE, imax = 1, imin = 1;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
//            int temp = imax;
//            imax = imin;
//            imin = temp;
            imax = imax ^ imin;
            imin = imin ^ imax;
            imax = imin ^ imax;
        }
        imax = Math.max(imax * nums[i],nums[i]);
        imin = Math.min(imin * nums[i],nums[i]);
        max = Math.max(max,imax);
    }
    return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
