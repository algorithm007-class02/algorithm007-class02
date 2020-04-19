//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length == 0 || k == 0) return new int[0];
            Queue<Integer> queue = new PriorityQueue<>((v1,v2) -> v2 - v1);
            for (int num : arr) {
                if (queue.size() < k) {
                    queue.offer(num);
                }else if (num < queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
            int[] result = new int[queue.size()];
            int index = 0;
            for ( int num : queue ) {
                result[index++] = num;
            }
            return result;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 *
 * public int[] getLeastNumbers(int[] arr, int k) {
 *             Arrays.sort(arr);
 *             return Arrays.copyOfRange(arr,0,k);
 *         }
 */
