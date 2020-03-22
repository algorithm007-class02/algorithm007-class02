class LeetCode_5_0068 {

    //1。两个for循环 暴力求解
    //2。。。。。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i =0 ; i < nums.length ;i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {
                return new int[] {i,map.get(b)};
            }else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}
