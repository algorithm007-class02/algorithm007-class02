package week04.g20200343040172;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * LeetCode-55 Jump game 跳跃游戏
 */
public class LeetCode_55_0172 {
    /**
     * 贪心算法，还没看懂
     * @param nums
     * @return
     */

    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
