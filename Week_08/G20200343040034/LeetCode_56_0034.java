package com.alang.learn.week8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_56_0034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] output = solution.merge(input);
        for (int[] arr : output) System.out.print(Arrays.toString(arr));
        System.out.println();
        input = new int[][]{{1,4},{4,5}};
        output = solution.merge(input);
        for (int[] arr : output) System.out.println(Arrays.toString(arr));
    }

    static public class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return intervals;
            }
            LinkedList<int[]> list = new LinkedList<>();
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            list.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                if (list.getLast()[1] < intervals[i][0]) {
                    list.add(intervals[i]);
                } else {
                    list.getLast()[1] = Math.max(intervals[i][1], list.getLast()[1]);
                }
            }
            return list.toArray(new int[0][0]);
        }
    }
}
