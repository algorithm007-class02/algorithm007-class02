import java.util.Arrays;
import java.util.HashMap;

class LeetCode_189_0236 {
    /**
     * 暴力法
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
        }
    }

    /**
     * 使用额外数组
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        // 解法A
//         k = k % nums.length;
//        int[] tmp = new int[nums.length];
//        int index = 0;
//        for (int i = nums.length - k; i < nums.length; i++) {
//            tmp[index] = nums[i];
//            index++;
//        }
//        for (int i = 0; i < k; i++) {
//            for (int j = nums.length - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            nums[i] = tmp[i];
//        }

        // 解法B
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i % k] = nums[i];
        }
        // 循环替换数组可用下面arraycopy替换
        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = tmp[i];
        // }
        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }

    /**
     * 有 a = k % n 个数被移至头部
     * 现将整个数组反转，再将前 a 个数反转，
     * 最后将 a - nums.length 个数反转
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}