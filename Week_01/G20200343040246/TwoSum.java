package Week_01.G20200343040246;

import java.util.Map;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = new int[]{1,5,6,8,9};
        solution.twoSum(nums, 10);
        solution.twoSum2(nums, 10);
        solution.twoSum3(nums, 10);
    }
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 1: two-pass loop  O(n^2)
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }
    
        public int[] twoSum2(int[] nums, int target) {
            // 2: two-pass hash O(n)
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff) && map.get(diff) != i) {
                    return new int[]{i, map.get(diff)};
                }
            }
            return new int[]{};
        }
    
        public int[] twoSum3(int[] nums, int target) {
            // 3: one-pass hash O(n)
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[]{map.get(diff), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    
    }
}