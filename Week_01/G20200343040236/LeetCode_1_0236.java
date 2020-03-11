import java.util.Arrays;
import java.util.HashMap;

class LeetCode_1_0236 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tr = target - nums[i];
            if (hashMap.containsKey(tr)) {
                return new int[]{i, hashMap.get(tr)};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }
}