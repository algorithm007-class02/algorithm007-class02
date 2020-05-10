public class merge_56 {
    public static void main(String[] args) {
        int[][] data = {{1, 5}, {3, 8}};
        int[][] res = merge(data);
        for (int i = 0; i < res.length; i++) {

            for (int y = 0; y < res[i].length; y++) {
                System.out.println(res[i][y]+",");
            }
        }

    }

    private static int[][] merge(int[][] data) {
    // 先按照区间起始位置排序
        Arrays.sort(data, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[data.length][2];
        int idx = -1;
        for (int[] interval : data) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);


    }
}