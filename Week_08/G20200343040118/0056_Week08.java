class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        int result[][] = new int[intervals.length][2];
        int now = -1;
        for(int[] temp : intervals){
            if(now == -1 || temp[0] > result[now][1])
                result[++now]  = temp;
            else
                result[now][1] = Math.max(result[now][1],temp[1]);
        }
        return Arrays.copyOf(result,now+1);
    }
}