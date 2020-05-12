
//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_56_0206 {
    /**
     * 1、暴力循环，有重叠区域就进行合并
     * 2、排序+合并
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] peek = res.get(res.size() - 1);

            if (cur[0] > peek[1]) {
                res.add(cur);
            } else {
                peek[1] = Math.max(cur[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
