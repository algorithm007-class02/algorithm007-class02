package Week_01.G20200343040172;

/**
 * leetCode-283 移动零
 */
public class LeetCode_283_0172 {

    /**
     * 如果遇到的不是0，则依次搬移到前面，等搬移完毕以后进行补零操作
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
