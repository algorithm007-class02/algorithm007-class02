/**
 * 88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。

 

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
https://leetcode-cn.com/problems/merge-sorted-array/
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int insertPoint = m + n-1;
            int p1 = m -1, p2 = n-1;
            while (p2 >= 0 && p1 >= 0){
                if (nums2[p2] > nums1[p1]) {
                    nums1[insertPoint] = nums2[p2];
                    p2--;
                } else {
                    nums1[insertPoint] = nums1[p1];
                    p1--;
                }
                insertPoint--;
            }
            // 因为 p2 指下标，下标是从 0 开始的，所以拷贝长度需要为 p2 + 1;如果时候 p2 = -1 的时候就表示不用拷贝了。
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);     
    }
}