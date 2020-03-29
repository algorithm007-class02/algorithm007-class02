class LeetCode_1_0068 {

    //1. 两个for循环 O(n^2)
    //2. hash 表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();//(target - nums[index]) : index
        for (int i = 0 ; i < nums.length ;i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {i,map.get(nums[i])};
            }else {
                map.put(target - nums[i] , i);
            }
        }
        throw  new RuntimeException("not found");
    }
}