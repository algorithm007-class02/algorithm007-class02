package Week_08.G20200343040246;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_56_0246 {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
            {1,3},{2,6},{8,10},{15,18}
        };
        int[][] ans = new LeetCode_56_0246().merge(intervals);
        for(int[] row : ans) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                // 下一个 start 左区间已无法涵盖当前 end 右区间
                // 已找到 j 的另一半 i
                list.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}