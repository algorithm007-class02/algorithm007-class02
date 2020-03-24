public class LeetCode_1_0222 {

    /**
     * 两数之和
     * 解法1：暴力解法.两次遍历数组算出所有可能数字和是否和目标值相等，如果相等则返回两个下标
     * 时间负责度O(n^2) 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i , j};
                }
            }
        }

        throw new IllegalArgumentException("out solution");
    }

    /**
     * 解法2： 将数目标值减去数组下标位置的值作为key，数组遍历下标作为value保存在map 中，如果遍历过程中存在值在map中存在则返回两个下标
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumRe(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (numsMap.containsKey(nums[i])) {
                return new int[]{i, numsMap.get(nums[i])};
            } else {
                numsMap.put(key, i);
            }
        }
        throw new IllegalArgumentException("out solution");
    }
}