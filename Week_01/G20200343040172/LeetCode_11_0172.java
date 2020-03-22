package Week_01.G20200343040172;

public class LeetCode_11_0172 {

    /**
     * 暴力求解法，使用两层循环，求面积的最大值，以较矮的一边作为容器的高
     *
     * @param height
     * @return
     */
    public int maxAreaSolution_1(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
}
