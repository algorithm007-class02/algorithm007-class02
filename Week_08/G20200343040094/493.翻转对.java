/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 *
 * https://leetcode-cn.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (23.32%)
 * Likes:    85
 * Dislikes: 0
 * Total Accepted:    4K
 * Total Submissions: 16.4K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 
 * 你需要返回给定数组中的重要翻转对的数量。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 
 * 
 * 注意:
 * 
 * 
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) >> 1;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        int[] cache = new int[right - left + 1];
        int i = left, j = mid + 1, p = mid + 1, k = 0;
        while (i <= mid) {
            while(p <= right && nums[i] > 2 * (long)nums[p]) p++;
            count += p - (mid + 1);
            while(j <= right && nums[i] >= nums[j]) cache[k++] = nums[j++];
            cache[k++] = nums[i++];
        }
        while (j <= right) cache[k++] = nums[j++];
        System.arraycopy(cache, 0, nums, left, cache.length);
        return count;
    }
}
// @lc code=end
