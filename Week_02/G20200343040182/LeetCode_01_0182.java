class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                output[0] = map.get(complement);
                output[1] = i;
            }
            map.put(nums[i], i);

        }

        return output;

    }
}