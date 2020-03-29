class Solution {
    public int[] twoSum(int[] nums, int target) {
        int temp[] = new int[2];
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            if(	 map.containsKey(nums[i])){
                temp[0] = map.get(nums[i]);
                temp[1] = i;
                break;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return temp;
    }
}