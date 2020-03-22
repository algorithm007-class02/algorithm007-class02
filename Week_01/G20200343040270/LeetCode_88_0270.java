/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
class Solution {

    /**
     * 由于是有序数组，所以循环从尾部大值开始比较，将大值放置合并后数组的尾部
     * 两个数组有一方元素都完成放置则循环结束，若另一个数组有剩余则将数组剩余元素放置过去即可
     * 如果nums1剩余则结束，若nums2有剩余则放置到nums1中剩余的位置
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;//nums1尾部开始
        int j = n - 1;//nums2尾部开始
        int mergeIndex = m + n - 1;//合并后nums1数据尾部角标
        while (i >= 0 && j >= 0) {
            nums1[mergeIndex--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
}