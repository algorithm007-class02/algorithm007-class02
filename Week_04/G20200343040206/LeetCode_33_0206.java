
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
// 你可以假设数组中不存在重复的元素。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 示例 1:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//
//
// 示例 2:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_33_0206 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else {
                if (nums[left] <= target && target <= nums[mid]) {
                   right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 现在旋转的位置，然后再根据target在有序一组中查找
     *
     */
    public int search_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //查找最小值的下标
        int minIndex = findMin(nums);
        if (nums[minIndex] == target) {
            return minIndex;
        }
        int m = nums.length;
        int left,right;
        if (target <= nums[m - 1]) {
            left = minIndex;
            right = m-1;
        } else {
            left = 0;
            right = minIndex;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    private int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] > nums[end]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
