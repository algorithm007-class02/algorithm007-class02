class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        // 先对开始端进行排序
        Arrays.sort(intervals, Comparator.comparingInt(new ToIntFunction<int[]>() {
            @Override
            public int applyAsInt(int[] value) {
                return value[0];
            }
        }));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];
            int[] peek = res.get(res.size()-1);
            // 比较下一个的开始端 是否 比已经合并好区间的结束端大：res([l...r]),curInterval[0] > res(r) ?
            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            }else {
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}