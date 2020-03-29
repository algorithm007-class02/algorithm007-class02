package week02.g20200343040172;

/**
 * https://leetcode-cn.com/problems/rectangle-overlap/
 * LeetCode-836 矩形重叠
 */
public class LeetCode_836_0172 {

    /**
     * 采用排除法，排除掉一个矩形在另一个矩形的上面或者是下面或者是左面或者是右面的情况，即为相交的情况
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapSolution_1(int[] rec1, int[] rec2) {
                // left
        return !(rec1[2] <= rec2[0] ||
                // bottom
                rec1[3] <= rec2[1] ||
                // right
                rec1[0] >= rec2[2] ||
                // top
                rec1[1] >= rec2[3]);
    }

    /**
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形与 x 轴平行的边（水平边）投影到 x 轴上时会有交集，
     * 与 y 轴平行的边（竖直边）投影到 y 轴上时也会有交集。因此，我们可以将问题看作一维线段是否有交集的问题
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapSolution_2(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

}
