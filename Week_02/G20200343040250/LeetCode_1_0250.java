class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 使用空间换时间,
        // 将当前元素想要的值target - nums[i] 放在hash表中
        // 下次出现该数据就可以判定为是想要的元素
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null) {
                res[0] = value;
                res[1] = i;
            } {
                map.put(target - nums[i], i);
            }
        }
        return res;
    }
}