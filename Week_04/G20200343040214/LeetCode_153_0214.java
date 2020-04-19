package level2;

import java.util.Arrays;

public class Solution153 {
    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int size = nums.length;
        int low = 0;
        int high = size - 1;
        // 左边元素永远比右边元素大
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                // 中间点偏左 低位右移
                low = mid + 1;
            } else {
                // 中间点偏右 因为右边是一个递增的序列所以直接省略左边大于中间点的元素
                high = mid;
            }
        }
        return nums[low];
    }

    public int findMin2(int[] nums) {
        if (nums == null || nums.length <= 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int size = nums.length;
        if (nums[size - 1] > nums[0])
            return nums[0];
        int low = 0;
        int high = size - 1;
        // 变化点左侧元素大于 右侧元素
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = nums[mid];
            if (midVal > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (midVal < nums[mid - 1]) {
                return midVal;
            }
            if (midVal > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
