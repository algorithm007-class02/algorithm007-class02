package com.alang.learn.week8;

import java.util.Arrays;

/**
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * 通过次数14,445提交次数21,997
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1122_0034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1,arr2)));
    }

    static public class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] bucket = new int[1001];
            for (int a : arr1) {
                bucket[a]++;
            }
            int index = 0;
            for (int b : arr2) {
                while (bucket[b]-- > 0) {
                    arr1[index++] = b;
                }
            }
            for (int i = 0; i < 1001; i++) {
                while (bucket[i]-- > 0) {
                    arr1[index++] = i;
                }
            }
            return arr1;
        }
    }
}
