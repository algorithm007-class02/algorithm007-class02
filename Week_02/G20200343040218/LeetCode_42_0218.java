class Solution {
    /**
     * 暴力求解
     */
    public int trap(int[] height) {
        int res = 0;
        if (null == height || 3 > height.length) { return res;}

        int l = height.length;
        int[] leftMax = new int[l];
        int max = height[0];
        for (int i = 1; i < l - 1; i++) {
            max = Math.max(max, height[i-1]);
            leftMax[i] = max;
        }
        max = height[l-1];
        for (int i = l - 2; i > 0; i--) {
            max = Math.max(max, height[i+1]);
            int h = Math.min(leftMax[i], max);
            if (h - height[i] > 0) {
                res += h - height[i];
            }
        }
        return res;
    }

    /**
     * 从两端开始一起遍历
     * 从左边开始容易获取左边界最大值
     * 从右边开始容易获取右边界最大值
     * 从初步获取的两个边界值中较小的这端开始遍历
     * 每进一位，重新开始比较边界值后再确定从哪一端开始，直到相遇
     */
    public int trap2(int[] height) {
        int res = 0;
        if (null==height || 3 > height.length) { return res; }
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int i = 1;
        int j = height.length - 2;

        while (i <= j) {
            if (leftMax < rightMax) {
                if (leftMax > height[i]) {
                    res += leftMax - height[i];
                } else {
                    leftMax = height[i];
                }
                i++;
            } else {
                if (rightMax > height[j]) {
                    res += rightMax - height[j];
                } else {
                    rightMax = height[j];
                }
                j--;
            }
        }
        return res;
    }
}