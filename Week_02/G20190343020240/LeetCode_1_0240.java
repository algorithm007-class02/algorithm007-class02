class Solution {
    /**
     * HashMap存入数组和数组下标，利用target与数组之差再与数组剩余数组进行比较
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                //判断target-之前存入hashmap中的键是否与数组中的元素一致
                // 如果一致，表明存在两个数字之和为target，则返回之前存入数字的下标与本次的下标
                return new int[] {map.get(target - nums[i]),i};
            }
            //存入hashmap中，键为数组的值，值为数组下标
            map.put(nums[i],i);
        }
        return new int[] {0,0};
    }

    /**
     * 暴力求解，双重循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            for(int j = 1;j < nums.length;j++){
                if(i != j && target == nums[i] + nums[j]){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {0,0};
    }

    public static void main(String[] args) {
        int nums[] = {2,7,11,5}, target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}