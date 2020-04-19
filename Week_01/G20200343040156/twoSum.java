class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(null ==nums||nums.length ==0) {return null;}

        Map<Integer,Integer>  keyValueMap =new HashMap<>();

        for(int i=0;i<nums.length;++i){
            int currentValue = target-nums[i];
            if (keyValueMap.containsKey(currentValue)) {
                return new int[]{keyValueMap.get(currentValue),i};
            }
            keyValueMap.put(nums[i],i);
        }
        return null;
    }
}