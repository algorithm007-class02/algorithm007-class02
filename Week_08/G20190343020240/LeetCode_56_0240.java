import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for(int[] interval : intervals){
            if (index == -1 || interval[0] > res[index][1]){
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,index + 1);
    }
}
