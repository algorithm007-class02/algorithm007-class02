package Week_01.G20200343040246;

public class LeetCode_26_0246 {
    public static void main(final String[] args) {
        Solution solution = new LeetCode_26_0246().new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        solution.removeDuplicates(nums);
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            // 1. double point, index change O(n)
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    nums[++i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
