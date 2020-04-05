
public class LeetCode_45_0222 {

    /**
     * 暴力法
     * 我们知道最终要到达最后一个位置，然后我们找前一个位置，
     * 遍历数组，找到能到达它的位置，离它最远的就是要找的位置。
     * 然后继续找上上个位置，最后到了第 0 个位置就结束了
     * 也是贪心算法的题解， 局部最优最后达到全局最优
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int steps = 0;
        int position = nums.length - 1;
        while (position != 0) {
            for (int i = 0 ; i < position; i++) {
                if (nums[i] >= position- i) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    /**
     * 贪心算法，我们每次在可跳范围内选择可以使得跳的更远的位置
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}