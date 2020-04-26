//给你一个整数数组 nums 和一个整数 k。 
//
// 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。 
//
// 请返回这个数组中「优美子数组」的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
// 
//
// 示例 3： 
//
// 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 双指针


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1248 {
    /**累计和+hashmap
     * 看题还是要多结合测试用例看，题中的"连续"其实可以"不连续"，中间可以有偶数，只是奇数的连续*/
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        int sum=0;

        HashMap<Integer,Integer> map = new HashMap<>();
        //必要
        map.put(0,1);
        for (int num : nums) {
            if (num % 2 != 0) {
                sum += 1;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    /*
     * 耗时56ms（14%），使用内存47.6M（100%）
     * 233，身为560的变形，同样的hashMap怎么这么慢*/
}
//leetcode submit region end(Prohibit modification and deletion)
