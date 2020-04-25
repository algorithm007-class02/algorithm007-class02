/**
 * 两数之和：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 */
class Solution {

    /**
     * 解法一:暴力解法，两两相加，满足则返回结果
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 角标集合
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 解法二：
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}