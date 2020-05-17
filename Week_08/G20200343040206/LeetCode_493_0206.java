
//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
// 你需要返回给定数组中的重要翻转对的数量。
//
// 示例 1:
//
//
//输入: [1,3,2,3,1]
//输出: 2
//
//
// 示例 2:
//
//
//输入: [2,4,3,5,1]
//输出: 3
//
//
// 注意:
//
//
// 给定数组的长度不会超过50000。
// 输入数组中的所有数字都在32位整数的表示范围内。
//
// Related Topics 排序 树状数组 线段树 二分查找 分治算法


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_493_0206 {
    /**
     * 1、暴力循环
     * 2、桶排序
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int mid = s + (e - s) / 2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid ; i++) {
            while (j <= e && nums[i]/2.0 > nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        merge(nums, s, mid, e);
        return cnt;
    }

    private void merge(int[] nums, int s, int mid, int e) {
        int[] temp = new int[e - s + 1];
        int i = s, j = mid + 1, k = 0;
        while (i<= mid && j <= e){
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= e) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[s + p] = temp[p];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
