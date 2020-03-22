class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 空间换时间，登记每个人都需要的值，保存起来，如果接下来出现则为需要的两个值
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            Integer tempValue = map.get(nums[i]);
            int needValue = target - nums[i];
            if (tempValue != null ) {
                res[0] = tempValue;
                res[1] = i;
                break;
            } else {
                map.put(needValue, i);
            }
        }
        return res;
    }
}