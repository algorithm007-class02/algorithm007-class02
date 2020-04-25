//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window


import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums.length == 0 ) return new int[0];
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for ( int i = 0; i <= nums.length - k; i++ ) {
            int j = i + k - 1;
            if ( i <= maxIndex ) {
                if ( nums[j] < max ) {
                    result[i] = max;
                }else {
                    max = nums[j];
                    maxIndex = j;
                    result[i] = max;
                }
            }else {
                max = Integer.MIN_VALUE;
                for ( int z = i; z < i + k;z++ ) {
                    if ( nums[z] > max ) {
                        max = nums[z];
                        maxIndex = z;
                    }
                }
                result[i] = max;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 暴力法
 * public int[] maxSlidingWindow(int[] nums, int k) {
 *         int n = nums.length;
 *         if ( n * k == 0 ) return new int[0];
 *
 *         int[] result = new int[n - k + 1];
 *         for ( int i = 0 ; i < n - k + 1; i++ ) {
 *             int max = nums[i];
 *             for ( int j = i ; j < i + k ; j++ ) {
 *                 max = Math.max(max,nums[j]);
 *                 result[i] = max;
 *             }
 *         }
 *         return result;
 *     }
 *
 */

//  双端队列
//    ArrayDeque<Integer> deque = new ArrayDeque<>();
//    int[] nums;
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if ( n * k == 0 ) return new int[0];
//        if ( k ==1 ) return  nums;
//        this.nums = nums;
//        int maxIndex = 0;
//        for ( int i = 0 ; i < k ; i++) {
//            cleanDeque(i,k);
//            deque.addLast(i);
//            if ( nums[i] > nums[maxIndex] ) maxIndex = i;
//        }
//        int[] result = new int[n - k + 1];
//        result[0] = nums[maxIndex];
//
//        for ( int i = k ; i < n ;i++ ) {
//            cleanDeque(i,k);
//            deque.addLast(i);
//            result[i-k+1] = nums[deque.getFirst()];
//        }
//        return result;
//    }
//    void cleanDeque(int i ,int k){
//        if ( !deque.isEmpty() && deque.getFirst() == i - k )
//            deque.removeFirst();
//        while ( ! deque.isEmpty() && nums[i] > nums[deque.getLast()] )
//            deque.removeLast();
//    }