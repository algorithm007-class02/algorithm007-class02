
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [3,4,5,1,2]
//输出: 1
//
// 示例 2:
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_153_0206 {
    public int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] > nums[end]) {
                begin = mid + 1;
            } else if (nums[mid] < nums[end]){
                end = mid;
            }
        }
        return nums[begin];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
