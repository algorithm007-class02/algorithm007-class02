/**
 * 1. 两数之和
 * */
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int n = target-nums[i];
            if(map.containsKey(n)) {
                return new int[] {map.get(n),i};
            }
            map.put(nums[i],i);
        }
         throw new IllegalArgumentException("No two sum solution");
    }
}