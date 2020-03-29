package Week_01.G20200343040172;

/**
 * LeetCode-26 删除排序数组中的重复项
 */
public class LeetCode_26_0172 {

    /**
     * 方法二：参考自LeetCode上的评论
     * 思想：遇到相同的元素就继续往下走，遇到不同的元素则将其放到前面
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums.length;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[index] != nums[i]) nums[++index] = nums[i];
        return ++index;
    }

    /**
     * 最原始的思想：
     * 将需要删除的元素进行标记，然后统一进行移位操作
     * 各方面都很LOW
     *
     * @param nums
     * @return
     */

    public int removeDuplicates1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int oldNums = Integer.MAX_VALUE;
        int deletCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                oldNums = nums[0];
                continue;
            }
            if (nums[i] == oldNums) {
                nums[i] = Integer.MIN_VALUE;
                deletCount++;
            } else {
                oldNums = nums[i];
            }
        }
        if (deletCount == 0) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == Integer.MIN_VALUE) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] != Integer.MIN_VALUE) {
                            nums[i] = nums[j];
                            nums[j] = Integer.MIN_VALUE;
                            break;
                        }
                    }
                }
            }
        }
        return nums.length - deletCount;
    }
}
