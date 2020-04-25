package level1;

import java.util.Arrays;

public class SolutionM40 {
    // TODO 快排序
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
        int[] p = getLeastNumbers(nums, 4);
        System.out.println(Arrays.toString(p));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        quickSelect(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    // 快排序
    private static void quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (right >= k) {
            quickSelect(nums, start, right, k);
        } else {
            quickSelect(nums, left, end, k);
        }

    }

    // 快速排序
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int low, int high, int k) {
        int j = partition(nums, low, high);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        return j > k ? quickSearch(nums, low, j - 1, k) : quickSearch(nums, j + 1, high, k);
    }

    private static int partition(int[] nums, int low, int high) {
        int v = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < v)
                ;
            while (--j >= low && nums[j] > v)
                ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[low] = nums[j];
        nums[j] = v;
        return j;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        Arrays.sort(arr);
        int[] newArr = new int[k];
        System.arraycopy(arr, 0, newArr, 0, k);
        return newArr;
    }
}
