class Solution {
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len <= 1){ return intervals; }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < len - 1; i++){
            if(intervals[i] == null){ continue; }
            int low = intervals[i][0];
            int high = intervals[i][1];
            for(int j = i + 1; j < len; j++){
                if(intervals[j] == null){ continue; }
                if( !(intervals[j][0] > high) && !(intervals[j][1] < low) ){
                    intervals[j][0] = Math.min(low, intervals[j][0]);
                    intervals[j][1] = Math.max(high, intervals[j][1]);
                    intervals[i] = null;
                    break;
                }
            }
        }
        // System.out.println(Arrays.deepToString(intervals));
        for (int[] interval : intervals) {
            if (interval != null) {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}