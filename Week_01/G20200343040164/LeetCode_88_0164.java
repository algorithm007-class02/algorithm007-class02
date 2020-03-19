//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


import OCPDemo.Alert;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int master = m + n - 1;
        while ( (p1 >= 0) && (p2 >= 0) ) {
            if ( nums1[p1] < nums2[p2] ) {
                nums1[master--] = nums2[p2--];
            }else nums1[master--] = nums1[p1--];
        }
        //防止出现 m 为 0 的情况；以及nums1 的最小值 大于 nums2的最大值的情况
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
//    }