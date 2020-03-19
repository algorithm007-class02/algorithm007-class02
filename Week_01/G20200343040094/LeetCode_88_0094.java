/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1.空间复杂度O(m)
        // int[] nums1_copy = new int[m];
        // System.arraycopy(nums1, 0, nums1_copy, 0, m);
        // int i=0, j=0, k=0;
        // while(i < m && j < n) {
        //     nums1[k++] = nums1_copy[i] < nums2[j] ? nums1_copy[i++]: nums2[j++];
        // }
        // if (i < m) {
        //     System.arraycopy(nums1_copy, i, nums1, i+j, m+n-i-j);
        // }
        // if (j < n) {
        //     System.arraycopy(nums2, j, nums1, i+j, m+n-i-j);
        // }
        
        // 2.最优解，空间复杂度O(1)
        int i = m+n-1, tail1 = m - 1, tail2 = n - 1;
        while(tail1 >= 0 && tail2 >= 0) {
            nums1[i--] = nums1[tail1] > nums2[tail2] ? nums1[tail1--]: nums2[tail2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, tail2+1);
    }
}
// @lc code=end

