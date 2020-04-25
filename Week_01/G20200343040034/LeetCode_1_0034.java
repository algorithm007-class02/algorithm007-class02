class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums != null){
            HashMap<Integer,Integer> temp = new HashMap<>();
            for(int i = 0;i<nums.length;i++){
                int result = target - nums[i];
                if(temp.containsKey(result)){
                    int firstIndex = temp.get(result);
                    return new int[]{firstIndex,i} ;
                }
                temp.put(nums[i],i);
            }
        }
        throw(new RuntimeException("No Solution"));
    }
}