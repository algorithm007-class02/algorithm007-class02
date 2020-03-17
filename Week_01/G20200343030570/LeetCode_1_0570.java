class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap();
        
        for(int i = 0; i < nums.length; ++i) {
            int searchNum = target - nums[i];
            if(m.containsKey(searchNum)  && m.get(searchNum) != i) {
                int[] result = {i, m.get(searchNum)};
                return result;
            }
            m.put(nums[i], i);
        }

        return null;

    }
}