class Solution {
     public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v0 -> v0[0]));
        
        int[][] res = new int[intervals.length][2];
        int index = -1;

        for (int[] ints : intervals) {
            if (index == -1 || ints[0] > res[index][1]) {
                res[++index] = ints;
            } else {
                res[index][1] = Math.max(res[index][1], ints[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}