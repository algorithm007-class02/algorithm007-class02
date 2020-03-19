
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


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_88_0206 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n -1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        if ( p1 < 0){
            for (int i = 0; i <= p2; i++) {
                nums1[i] = nums2[i];
            }
        }

    }


    public static void main(String[] args) {
        LeetCode_88_0206  source = new LeetCode_88_0206();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};

        source.merge(nums1, 0, nums2, 1);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

