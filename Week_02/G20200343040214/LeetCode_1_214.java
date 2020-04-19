class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[] { i, map.get(nums[i]) };
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}