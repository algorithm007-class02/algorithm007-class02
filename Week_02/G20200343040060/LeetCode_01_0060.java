//两数之和 hash
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (hash.containsKey(res)) {
                return new int[]{hash.get(res), i};
            }
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}