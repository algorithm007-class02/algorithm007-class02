class Solution {
    //打表法 嗯嗯 比之前写的简结很多了！好看！
    public int[] twoSum(int[] nums, int target) {
      Map<Integer,Integer> map = new HashMap<Integer,Integer>();
      int temp = 0;
      for(int i = 0 ; i < nums.length ; i++){
          if(map.containsKey(nums[i])){
              int[] returnArray = {map.get(nums[i]),i};
                return returnArray;
          }
            temp = target - nums[i];
            map.put(temp,i);
      }
      return null;
       
    }
}