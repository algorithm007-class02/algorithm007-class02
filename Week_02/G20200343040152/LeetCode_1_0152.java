class Solution {
    public int[] twoSum(int[] nums, int target) {
        // double hash
        //return doubleHash(nums,target);
        // sigle hash
        return singleHash(nums,target);
       
    }

    public int[] doubleHash(int[] nums, int target){
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            numMap.put(nums[i],i);
        }
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            Integer position = numMap.get(target-nums[i]);
            if(position!=null && position!=i){
                result[0] = i;
                result[1] = position;
                break;
            }
        }
        return result;
    }

    public int[] singleHash(int[] nums, int target){
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
           int complement = target - nums[i];
           if(numMap.containsKey(complement)){
               return new int[]{i,numMap.get(complement)};
           }
           numMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}