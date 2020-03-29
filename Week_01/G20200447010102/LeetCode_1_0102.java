import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map1 = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], i);
            
        }
        for (int i = 0; i < nums.length; i++) {
            int sup = target - nums[i];
            if (map1.containsKey(sup) && map1.get(sup) != i) {
                return new int[] {i, map1.get(sup)};
            }
        }
        return res;
    }
}