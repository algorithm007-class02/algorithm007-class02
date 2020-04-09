package level2;

public class Solution33 {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 5, 1 };
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return -1;
        int size = nums.length;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = nums[mid];
            if (midVal == target)
                return mid;
            // 需要判断左右边界 比二分查找多了边界判断
            if (nums[low] <= midVal) {
                // 左边升序
                if (target >= nums[low] && target <= midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= midVal && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
