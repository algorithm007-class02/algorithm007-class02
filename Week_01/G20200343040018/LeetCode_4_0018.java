/**
 * Created by haoyubian on 2020/3/15.
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。

  

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_4_0018 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cursor1 = m - 1;
        int cursor2 = n - 1;
        int cursor3 = m + n - 1;
        while (cursor1 >= 0 && cursor2 >= 0) {
            nums1[cursor3--] = nums1[cursor1] > nums2[cursor2] ? nums1[cursor1--] : nums2[cursor2--];
        }
        while (cursor2 >= 0) {
            nums1[cursor3--] = nums2[cursor2--];
        }
    }
}
