package Week_01.G20200343040172;

import java.util.Arrays;

/**
 * LeetCode-88 合并两个有序数组
 */
public class LeetCode_88_0172 {

    /**
     * 思路:将nums2中的n个元素依次保存到nums1从m开始的位置，然后将nums1中的元素进行排序
     *
     * @param nums1 将mus1中的m个元素以及nums2中的n个元素均保存在nums1中
     * @param m     nums1中的元素个数
     * @param nums2
     * @param n     nums2中的元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            if (i < m + n) nums1[i] = nums2[j++];
            else nums1[i] = Integer.MAX_VALUE;
        }
        Arrays.sort(nums1);
    }
}
