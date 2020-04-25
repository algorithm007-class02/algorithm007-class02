class Solution {
    /* two-sum 两数之和 */

    /**
     * 暴力破解
     * 时间复杂度 O(n^2)
     * 空间复杂度 O（1）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 哈希查找法
     * 时间 O(n)
     * 空间 O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        if (nums.length <= 1) {
            throw new IllegalArgumentException("No two sum solution");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}